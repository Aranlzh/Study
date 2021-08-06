package top.aranlzh.test;

import java.sql.*;

public class JdbcTest2 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        String url ="jdbc:mysql://localhost:3306/ssmbuild?useUnicode=true&characterEncoding=UTF-8";
        String username = "root";
        String password = "123456";

        // 1. 加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 2. 连接数据库，代表数据库
        Connection connection = DriverManager.getConnection(url, username, password);

        // 3. 编写SQL
        String sql = "INSERT into books(bookID, bookName, bookCounts, detail) VALUES (?,?,?,?)";

        // 4. 向数据库发送SQL的对象Statement
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,5);
        preparedStatement.setString(2,"Netty实战");
        preparedStatement.setInt(3,5);
        preparedStatement.setString(4,"Netty实战教学");


        // 5. 执行SQL
        int i = preparedStatement.executeUpdate();
        if (i>0) {
            System.out.println("插入成功");
        }

        // 6. 关闭链接，释放资源（一定要做） 先开后关
        preparedStatement.close();
        connection.close();

    }

}
