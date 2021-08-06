package top.aranlzh.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.UUID;

public class FileUploadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 判断表单是普通的表单还是带文件的表单
        if (!ServletFileUpload.isMultipartContent(req)) {
            System.out.println("这是一个普通的表单");
            return;
        }

        // 创建上传文件的保存路径，建议保存在 WEB-INF 目录下，用户无法直接访问上传的文件
        String uploadPath = this.getServletContext().getRealPath("/WEB-INF/upload");
        File uploadFile = new File(uploadPath);
        if (!uploadFile.exists()) {
            uploadFile.mkdir();
        }

        // 临时路径，如果文件超过了预期的大小，我们就把它放进一个临时文件中，过几天自动删除，或者提醒用户转存为永久
        String tmpPath = this.getServletContext().getRealPath("/WEB-INF/tmp");
        File tmpFile = new File(tmpPath);
        if (!tmpFile.exists()) {
            tmpFile.mkdir();
        }

        // 处理上传的文件，一般都需要通过流来获取，我们可以使用request.getInputStream() 原生态的文件上传流获取，十分麻烦
        // 但是我们都建议使用 Apache 的文件上传组件来实现，commons-fileupload，它需要依赖于 commons-io 组件

        // 1. 创建 DiskFileItemFactory 对象：处理文件上传路径或者大小限制
        DiskFileItemFactory factory = getDiskFileItemFactory(tmpFile);
        // 2. 获取 ServletFileUpload
        ServletFileUpload upload = getServletFileUpload(factory);
        // 3. 处理上传的文件
        String msg = null;
        try {
            msg = uploadParseRequest(upload, req, uploadPath);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // servlet 请求转发消息
        req.setAttribute("msg", msg);
        req.getRequestDispatcher("info.jsp").forward(req, resp);
    }

    public static DiskFileItemFactory getDiskFileItemFactory(File file) {
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // 通过这个工厂设置一个缓冲区，当上传的文件大于这个缓冲区的时候，将他放到临时文件中
        factory.setSizeThreshold(1024*1024);
        factory.setRepository(file);
        return factory;
    }

    public static ServletFileUpload getServletFileUpload(DiskFileItemFactory factory){
        ServletFileUpload upload = new ServletFileUpload(factory);
        // 监听文件上传速度
        upload.setProgressListener(new ProgressListener() {
            /**
             *
             * @param pBytesRead 已经读取到的文件大小
             * @param pContentLength 文件大小
             * @param pItems
             */
            public void update(long pBytesRead, long pContentLength, int pItems) {
                System.out.println("总大小：" + pContentLength + " 已上传：" + pBytesRead);
                long l = pBytesRead * 100 / pContentLength;
                System.out.println("上传进度：" + l + "%");
            }
        });

        // 处理乱码问题
        upload.setHeaderEncoding("UTF-8");
        // 设置单个文件的最大值
        upload.setFileSizeMax(1024*1024*10);
        // 设置总共能够上传的大小
        // 1024 = 1kb * 1024 = 1M * 10 = 10M
        upload.setSizeMax(1024*1024*10);

        return upload;
    }

    public static String uploadParseRequest(ServletFileUpload upload, HttpServletRequest req, String uploadPath) throws FileUploadException, IOException {

        String msg = "";

        // 解析前端请求，封装成一个FileItem对象
        List<FileItem> fileItems = upload.parseRequest(req);
        for (FileItem fileItem : fileItems) {
            // 判断表单是普通的表单还是带文件的表单
            if (fileItem.isFormField()) {
                // getFieldName指的是前端表单控件的name
                String name = fileItem.getFieldName();
                String value = fileItem.getString("UTF-8");
                System.out.println(name + ":" + value);
            } else {
                // 是上传的文件
                // ======================处理文件开始========================

                // 拿到文件名字
                String uploadFileName = fileItem.getName();
                System.out.println("上传的文件名：" + uploadFileName);

                if ("".equals(uploadFileName.trim())||uploadFileName==null) {
                    continue;
                }

                // 获得上传的文件名
                String fileName = uploadFileName.substring(uploadFileName.lastIndexOf("/") + 1);
                // 获得文件的后缀名
                String fileExtName = uploadFileName.substring(uploadFileName.lastIndexOf(".") + 1);

                /*
                    如果文件后缀名 fileExtName 不是我们所需要的
                    就直接 return 不处理，告诉用户文件类型不对
                 */
                System.out.println("文件信息【文件名：" + fileName + " 文件类型：" + fileExtName + "】");


                // JNI = Java Native Interface ===> jdk/include/jni.h
                // new Thread(()->{System.out.println("Hello")}).start(); ===> private native void start0();
                // 网络传输中的东西，都需要序列化 implements Serializable：标记接口，JVM ---> 本地防范栈 native ---> c++

                // 可以使用UUID（唯一识别的通用码），保证文件名的唯一；
                // UUID.randomUUID()，随机生成一个唯一识别的通用码；
                String uuidPath = UUID.randomUUID().toString();

                // ======================处理文件完毕========================

                // 存在哪？ uploadPath
                // 文件真实存在的路径 realPath
                String realPath = uploadPath + "/" + uuidPath;
                File realPathFile = new File(realPath);
                if (!realPathFile.exists()) {
                    realPathFile.mkdir();
                }

                // ======================存放地址完毕========================

                // 获得文件上传的流
                InputStream inputStream = fileItem.getInputStream();

                // 创建一个文件输出流
                // realPath = 真实的文件夹
                // 查了一个文件名；加上输出文件的名字+"/" +uuidFileName
                FileOutputStream fos = new FileOutputStream(realPath + "/" + fileName);

                // 创建一个缓冲区
                byte[] buffer = new byte[1024 * 1024];

                // 判断是否读取完毕
                int len = 0;
                // 如果大于0说明还存在数据
                while ((len = inputStream.read(buffer))>0) {
                    fos.write(buffer, 0, len);
                }

                // 关闭流
                fos.close();
                inputStream.close();

                msg = "文件上传成功";
                fileItem.delete(); // 上传成功，清除临时文件
            }
        }

        return msg;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
