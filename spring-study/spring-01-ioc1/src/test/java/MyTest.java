import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.aranlzh.dao.UserDaoMysqlImpl;
import top.aranlzh.dao.UserDaoOracleImpl;
import top.aranlzh.service.UserService;
import top.aranlzh.service.UserServiceImpl;

public class MyTest {

    public static void main(String[] args) {
        // 用户实际调用的是业务层，dao层他们不需要接触
        UserService userService = new UserServiceImpl();

        ((UserServiceImpl) userService).setUserDao(new UserDaoOracleImpl());

        userService.getUser();

        // 获取Spring上下文对象
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        userService = context.getBean("userServiceImpl", UserService.class);
        userService.getUser();
    }
}
