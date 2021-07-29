package top.aranlzh.demo01;

public class Client {

    public static void main(String[] args) {
        // 房东要出租房子
        Host host = new Host();

        // 房东直接出租房子
//        host.rent();

        // 房东没空，自己贴广告啥的浪费时间，交给中介
        // 代理，中介帮房东租房子，代理角色一般会有一些附属操作
        Proxy proxy = new Proxy(host);
        // 你不用面对房东，直接找中介租房即可
        proxy.rent();


    }

}
