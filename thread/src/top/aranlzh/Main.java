package top.aranlzh;

/**
 * 多线程编程步骤
 * 1. 创建资源类，在资源类创建属性和操作方法
 * 2. 在资源类操作方法
 * 2.1 判断
 * 2.2 干活
 * 2.3 通知
 * 3. 创建多个线程，调用资源类的操作方法
 * 4. 防止虚假唤醒问题
 */
public class Main {

    public static void main(String[] args) {
        Thread aa = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "::" + Thread.currentThread().isDaemon());
            while (true) {

            }
        }, "aa");

        // 设置为守护线程之后，主线程结束了，它也就结束了
        // 如果没有设置为守护线程，则主线程结束了，它（用户线程）也不会结束
        aa.setDaemon(true);
        aa.start();

        System.out.println(Thread.currentThread().getName()+" over");

    }

}
