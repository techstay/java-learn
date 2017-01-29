package yitian.learn.jdbc;


import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;

import javax.sql.DataSource;

public abstract class DataSourceUtils {
    public static DataSource getDataSource() {
        MysqlConnectionPoolDataSource dataSource = new MysqlConnectionPoolDataSource();
        dataSource.setUrl(JdbcUtil.URL);
        dataSource.setUser(JdbcUtil.USERNAME);
        dataSource.setPassword(JdbcUtil.PASSWORD);
        dataSource.setUseSSL(false);
        return dataSource;
    }
}
