package top.aranlzh.demo02;

// 日常使用增删改查的时候，有个需求，每次调用的时候说调用的是哪个方法
public class Client {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
//        userService.add();

        UserServiceProxy proxy = new UserServiceProxy();
        proxy.setUserService(userService);

        proxy.add();
    }
}
