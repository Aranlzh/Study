package top.aranlzh.udp.chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class UdpSenderDemo01 {
    public static void main(String[] args) throws Exception {
        // 1. 建立一个socket
        DatagramSocket socket = new DatagramSocket(8888);

        // 2. 建个包
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String data = reader.readLine();
            byte[] datas = data.getBytes();
            // 发送给谁
            DatagramPacket packet = new DatagramPacket(datas, 0, datas.length, new InetSocketAddress("localhost", 6666));

            // 3. 发送包
            socket.send(packet);
            if ("bye".equals(data)) {
                break;
            }
        }

        // 4. 关闭流
        reader.close();
        socket.close();
    }
}
