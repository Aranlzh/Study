package top.aranlzh.response;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

public class FileDownloadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 要获取下载文件的路径
        String realPath = this.getServletContext().getRealPath("/WEB-INF/classes/test.jpg");
        // String realPath = "D:\\Study\\javaweb-study\\javaweb-01-servlet\\target\\classes\\test.jpg";
        System.out.println("下载文件的路径"+realPath);
        // 下载的文件名是啥？
        String fileName = realPath.substring(realPath.lastIndexOf("\\") + 1);
        // 设置想办法让浏览器能够支持(Content-Disposition)下载我们需要的东西，中文文件名URLEncoder.encode编码，否住可能乱码
        resp.setHeader("Content-Disposition","attachment;filename="+URLEncoder.encode(fileName));

        // 获取下载文件的输入流
        FileInputStream in = new FileInputStream(realPath);
        // 创建缓冲区
        int len = 0;
        byte[] buffer = new byte[1024];
        // 获取OutputStream对象
        ServletOutputStream out = resp.getOutputStream();
        // 将FileOutputStream流写入buffer缓冲区，使用OutputStream将缓冲区中的数据输出到客户端
        while ((len=in.read(buffer))>0) {
            out.write(buffer, 0, len);
        }

        in.close();
        out.close();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
