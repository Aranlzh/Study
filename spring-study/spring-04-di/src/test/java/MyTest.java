import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.aranlzh.pojo.Student;
import top.aranlzh.pojo.User;

public class MyTest {

    public static void main(String[] args) {
       ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
       Student student = context.getBean("student", Student.class);
       System.out.println(student.toString());
    }

    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("userbeans.xml");
        User user = context.getBean("user", User.class);
        User user1 = context.getBean("user", User.class);
        System.out.println(user.toString());
        System.out.println(user1.toString());
        System.out.println("prototype:"+(user==user1));

        User user2 = context.getBean("user2", User.class);
        User user3 = context.getBean("user2", User.class);
        System.out.println(user2.toString());
        System.out.println(user3.toString());
        System.out.println("singleton:"+(user2==user3));
    }

}
