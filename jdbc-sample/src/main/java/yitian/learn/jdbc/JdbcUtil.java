package yitian.learn.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtil {
    public static String URL = "jdbc:mysql://localhost:3306/jdbclearn";
    public static String USERNAME = "root";
    public static String PASSWORD = "12345678";

    public static Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        return connection;
    }
}
