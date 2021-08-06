package top.aranlzh.test;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcTest3 {

    @Test
    public  void test() {
        String url ="jdbc:mysql://localhost:3306/ssmbuild?useUnicode=true&characterEncoding=UTF-8";
        String username = "root";
        String password = "123456";
        Connection connection = null;

        try {
            // 1. 加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2. 连接数据库，代表数据库
            connection = DriverManager.getConnection(url, username, password);

            // 3.通知数据库开启事务
            connection.setAutoCommit(false);

            String sql = "update books set bookCounts = bookCounts-1 where bookID=5;";
            connection.prepareStatement(sql).executeUpdate();


            // 制造错误
            int i = 1 / 0;

            String sql1 = "update books set bookCounts = bookCounts-1 where bookID=1;";
            connection.prepareStatement(sql1).executeUpdate();

            // 以上两条sql都执行成功，就提交事务
            connection.commit();
            System.out.println("执行成功");
        } catch (Exception e) {
            e.printStackTrace();
            try {
                // 如果出现异常，就通知数据库回滚
                connection.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }finally {
            // 6. 关闭链接，释放资源（一定要做） 先开后关
            if (connection!=null){
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }

}
