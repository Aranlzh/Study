package top.aranlzh.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

// 接收端：还是要等待客户端的链接！
public class UdpReceiver {
    public static void main(String[] args) throws Exception {
        // 1. 开放端口
        DatagramSocket socket = new DatagramSocket(9090);

        // 2. 接收数据包
        byte[] buffer = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);

        // 3. 阻塞接收
        socket.receive(packet);

        System.out.println(packet.getAddress().getHostAddress());
        System.out.println(new String(packet.getData(), 0, packet.getLength()));

        // 4. 关闭流
        socket.close();

    }
}
