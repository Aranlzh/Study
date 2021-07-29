package top.aranlzh.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpFileUploadServer {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream is = null;
        FileOutputStream fos = null;
        OutputStream os = null;

        try {
            // 1. 我得有一个地址
            serverSocket = new ServerSocket(9000);
            // 2. 监听客户端的连接
            socket = serverSocket.accept();
            // 3. 读取客户端的消息
            is = socket.getInputStream();
            // 4. 文件输出
            fos = new FileOutputStream(new File("receive.jpg"));
            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }

            // 通知客户端我接收完毕了
            os = socket.getOutputStream();
            os.write("我接收完毕了，你可以断开了".getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 5. 关闭资源
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
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
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
