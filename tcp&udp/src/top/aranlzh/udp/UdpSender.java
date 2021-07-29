package top.aranlzh.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

// 发送端：不需要连接服务器
public class UdpSender {
    public static void main(String[] args) throws Exception {
        // 1. 建立一个socket
        DatagramSocket socket = new DatagramSocket(8080);

        // 2. 建个包
        String msg = "你好";
        InetAddress localhost = InetAddress.getByName("localhost");
        int port = 9090;

        // 发送给谁
        DatagramPacket packet = new DatagramPacket(msg.getBytes(), 0, msg.getBytes().length, localhost, port);

        // 3. 发送包
        socket.send(packet);

        // 4. 关闭流
        socket.close();

    }
}
