package top.aranlzh.test;

import java.sql.*;

public class JdbcTest {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        String url ="jdbc:mysql://localhost:3306/ssmbuild?useUnicode=true&characterEncoding=UTF-8";
        String username = "root";
        String password = "123456";

        // 1. 加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 2. 连接数据库，代表数据库
        Connection connection = DriverManager.getConnection(url, username, password);
        // 3. 向数据库发送SQL的对象Statement
        Statement statement = connection.createStatement();
        // 4. 编写SQL
        String sql = "select * from books;";

        // 受影响的行数，增删改都用executeUpdate即可
        // int i = statement.executeUpdate(sql);

        // 5. 执行SQL，返回一个ResultSet：结果集
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            System.out.println("bookID:"+resultSet.getObject("bookID"));
            System.out.println("bookName:"+resultSet.getObject("bookName"));
            System.out.println("bookCounts:"+resultSet.getObject("bookCounts"));
            System.out.println("detail:"+resultSet.getObject("detail"));
        }
        // 6. 关闭链接，释放资源（一定要做） 先开后关
        resultSet.close();
        statement.close();
        connection.close();

    }

}
