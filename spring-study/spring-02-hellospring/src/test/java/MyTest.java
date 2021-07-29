import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.aranlzh.pojo.Hello;

public class MyTest {

    public static void main(String[] args) {
        // 获取Spring上下文对象
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        // 我们的对象现在都在spring中管理了，我们要使用，直接取出来就好了
        Hello hello = context.getBean("hello", Hello.class);
        System.out.println(hello.toString());
    }

}
