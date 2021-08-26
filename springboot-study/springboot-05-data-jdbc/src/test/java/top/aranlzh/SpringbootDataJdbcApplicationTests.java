package top.aranlzh;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
public class SpringbootDataJdbcApplicationTests {

    // DI注入数据源
    // 如果提示没有这个东西，首先要检查一下有无默认生成应用启动器：
    // @SpringBootApplication
    // public class DataJdbcApplication {
    @Autowired
    DataSource dataSource;

    //  DataSourceAutoConfiguration.java -->
    //  @Configuration(proxyBeanMethods = false)
    // 	@Conditional(PooledDataSourceCondition.class)
    // 	@ConditionalOnMissingBean({ DataSource.class, XADataSource.class })
    // 	@Import({ DataSourceConfiguration.Hikari.class, DataSourceConfiguration.Tomcat.class,
    // 			DataSourceConfiguration.Dbcp2.class, DataSourceConfiguration.OracleUcp.class,
    // 			DataSourceConfiguration.Generic.class, DataSourceJmxConfiguration.class })
    // 	protected static class PooledDataSourceConfiguration {
    //
    // 	}

    @Test
    public void contextLoads() throws SQLException {
        //看一下默认数据源
        System.out.println(dataSource.getClass());
        //获得连接
        Connection connection =   dataSource.getConnection();
        System.out.println(connection);

        DruidDataSource druidDataSource = (DruidDataSource) dataSource;
        System.out.println("druidDataSource 数据源最大连接数：" + druidDataSource.getMaxActive());
        System.out.println("druidDataSource 数据源初始化连接数：" + druidDataSource.getInitialSize());

        //关闭连接
        connection.close();
    }



}
