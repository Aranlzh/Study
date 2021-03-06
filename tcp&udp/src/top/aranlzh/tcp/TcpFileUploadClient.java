package top.aranlzh.tcp;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class TcpFileUploadClient {
    public static void main(String[] args) {
        Socket socket = null;
        OutputStream os = null;
        FileInputStream fis = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;

        try {
            // 1. 创建一个socket连接
            socket = new Socket(InetAddress.getByName("127.0.0.1"), 9000);
            // 2. 创建一个输出流
            os = socket.getOutputStream();
            // 3. 文件流
            fis = new FileInputStream(new File("test.jpg"));
            // 4. 写出文件
            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                os.write(buffer, 0, len);
            }

            // 通知服务器，我已经结束了
            socket.shutdownOutput();

            // 确定服务器接收完毕，才能够断开连接
            is = socket.getInputStream();
            // String byte[]
            baos = new ByteArrayOutputStream();
            byte[] buffer2 = new byte[1024];

            int len2;
            while ((len2 = is.read(buffer2)) != -1) {
                baos.write(buffer2, 0, len2);
            }
            System.out.println(baos.toString());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (baos != null) {
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
