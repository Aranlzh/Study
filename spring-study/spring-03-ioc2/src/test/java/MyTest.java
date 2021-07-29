import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.aranlzh.pojo.User;
import top.aranlzh.pojo.UserT;

public class MyTest {

    public static void main(String[] args) {
//        User user = new User();

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = context.getBean("user", User.class);
        User user2 = context.getBean("sys_user", User.class);
        System.out.println(user==user2);
        user.show();
        user2.show();
        UserT user3 = context.getBean("userT", UserT.class);
        user3.show();
        UserT user4 = context.getBean("user2", UserT.class);
        user4.show();
        UserT user5 = context.getBean("u3", UserT.class);
        user5.show();
        UserT user6 = context.getBean("u4", UserT.class);
        user6.show();
    }

}
