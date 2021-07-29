import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.aranlzh.mapper.UserMapper;
import top.aranlzh.pojo.User;

public class MyTest {

    @Test
    public static void test() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper userMapper = context.getBean("userMapper", UserMapper.class);
        for (User user : userMapper.getAllUser()) {
            System.out.println(user);
        }
    }
}
