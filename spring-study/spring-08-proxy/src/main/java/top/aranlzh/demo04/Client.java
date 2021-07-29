package top.aranlzh.demo04;

import top.aranlzh.demo02.UserService;
import top.aranlzh.demo02.UserServiceImpl;

public class Client {
    public static void main(String[] args) {
        // 真实角色
        UserServiceImpl userService = new UserServiceImpl();
        // 代理角色，不存在
        ProxyInvocationHandler pih = new ProxyInvocationHandler();
        pih.setTarget(userService);

        UserService proxy = (UserService) pih.getProxy();

        proxy.add();
    }
}
