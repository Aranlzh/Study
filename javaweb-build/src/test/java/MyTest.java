import org.junit.Test;
import top.aranlzh.pojo.User;
import top.aranlzh.service.user.UserServiceImpl;

public class MyTest {

    @Test
    public void jdbcTest(){
        UserServiceImpl userService = new UserServiceImpl();
        User admin = userService.login("admin", "111111");
        System.out.println(admin.getUserPassword());
    }

}
