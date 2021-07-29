package top.aranlzh.udp.chat;

public class UdpChat02 {
    public static void main(String[] args) {
        new Thread(new TalkSend(5555,"localhost", 8888)).start();
        new Thread(new TalkReceive(9999,"luzh")).start();
    }
}
