package top.aranlzh.udp.chat;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpReceiverDemo01 {
    public static void main(String[] args) throws Exception {
        // 1. 开放端口
        DatagramSocket socket = new DatagramSocket(6666);

        while (true) {
            // 准备接收包裹
            byte[] container = new byte[1024];
            DatagramPacket packet = new DatagramPacket(container, 0, container.length);
            // 阻塞接收
            socket.receive(packet);

            // 断开连接 bye
            byte[] data = packet.getData();
            String receiveData = new String(data, 0, data.length);
            System.out.println(receiveData);
            if ("bye".equals(receiveData)) {
                break;
            }
        }

        // 关闭流
        socket.close();
    }
}
