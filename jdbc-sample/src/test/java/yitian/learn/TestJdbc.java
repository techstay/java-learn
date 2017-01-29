package yitian.learn;


import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import yitian.learn.jdbc.JdbcUtil;
import yitian.learn.jdbc.User;

import javax.sql.DataSource;
import javax.sql.RowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertNotNull;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestJdbc {

    private static Logger logger;
    private static Connection connection;

    @BeforeClass
    public static void init() throws SQLException {
        logger = LogManager.getLogger();
        connection = JdbcUtil.getConnection();
    }

    @AfterClass
    public static void clean() throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("DELETE FROM user WHERE username LIKE 'test%'");
        }
        connection.close();
    }

    @Test
    public void testConnection() {
        assertNotNull(connection);
    }

    @Test
    public void testInsert() throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("INSERT INTO user(username,password) VALUES('test1','123456')");
        }
    }

    @Test
    public void testSelect() throws SQLException {
        List<User> users = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet rs = statement.executeQuery("SELECT *FROM user")) {

                while (rs.next()) {
                    User user = new User();
                    user.setId(rs.getInt(1));
                    user.setUsername(rs.getString(2));
                    user.setPassword(rs.getString(3));
                    user.setNickname(rs.getString(4));
                    user.setBirthday(rs.getDate(5));
                    users.add(user);
                }
            }
        }
        users.forEach(user -> logger.info(user.toString()));

    }

    @Test
    public void testPreparedInsert() throws SQLException {
        try (PreparedStatement statement
                     = connection.prepareStatement("INSERT INTO user(username,password,nickname,birthday) VALUES(?,?,?,?)")) {
            statement.setString(1, "test2");
            statement.setString(2, "12345678");
            statement.setString(3, "张三");
            statement.setDate(4, new Date(new java.util.Date().getTime()));
            int rows = statement.executeUpdate();
            assertThat(rows, is(1));
        }
    }

    @Test
    public void testResultSetMetaData() throws SQLException {
        try (PreparedStatement statement
                     = connection.prepareStatement("SELECT *FROM user")) {
            try (ResultSet rs = statement.executeQuery()) {
                ResultSetMetaData metaData = rs.getMetaData();
                for (int i = 0; i < metaData.getColumnCount(); ++i) {
                    System.out.print(String.format("%s\t", metaData.getColumnName(i + 1)));
                }
                System.out.println();
                while (rs.next()) {
                    for (int i = 0; i < metaData.getColumnCount(); ++i) {
                        System.out.print(String.format("%s\t", rs.getString(i + 1)));
                    }
                    System.out.println();
                }

            }
        }
    }

    @Test
    public void testDatabaseMetaData() throws SQLException {
        DatabaseMetaData metaData = connection.getMetaData();
        logger.info("DriverName:{}", metaData.getDriverName());
        logger.info("DriverVersion:{}", metaData.getDriverVersion());

    }

    @Test
    public void testDelete() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("DELETE FROM user WHERE username LIKE 'test%'")) {

        }
    }

    @Test
    public void testUpdatableResultSet() throws SQLException {
        try (Statement statement
                     = connection.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_UPDATABLE)) {
            statement.executeUpdate("INSERT INTO user(username,password) VALUES('test3','112233')");
            try (ResultSet rs = statement.executeQuery("SELECT *FROM user WHERE username='test3'")) {
                rs.absolute(1);
                rs.updateString("password", "987654321");
                rs.updateRow();
            }
            try (ResultSet rs = statement.executeQuery("SELECT *FROM user WHERE username='test3'")) {
                rs.absolute(1);
                assertThat(rs.getString("password"), equalTo("987654321"));
            }

        }
    }

    @Test
    public void testJdbcRowSet() throws SQLException {
        RowSetFactory factory = RowSetProvider.newFactory();
        try (RowSet rs = factory.createJdbcRowSet()) {
            rs.setUrl(JdbcUtil.URL);
            rs.setUsername(JdbcUtil.USERNAME);
            rs.setPassword(JdbcUtil.PASSWORD);
            rs.setCommand("select *from user");
            rs.execute();

            ResultSetMetaData metaData = rs.getMetaData();
            for (int i = 0; i < metaData.getColumnCount(); ++i) {
                System.out.print(String.format("%s\t", metaData.getColumnName(i + 1)));
            }
            System.out.println();
            while (rs.next()) {
                for (int i = 0; i < metaData.getColumnCount(); ++i) {
                    System.out.print(String.format("%s\t", rs.getString(i + 1)));
                }
                System.out.println();
            }
        }

    }


    @Test
    public void testInProcedure() throws SQLException {
        try (CallableStatement statement = connection.prepareCall("CALL find_all_blogs_of(?)")) {
            statement.setInt(1, 1);
            ResultSet rs = statement.executeQuery();

            List<User> users = new ArrayList<>();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt(rs.getInt(1)));
                user.setId(rs.getInt(1));
                user.setUsername(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setNickname(rs.getString(4));
                user.setBirthday(rs.getDate(5));
                users.add(user);
            }
            users.forEach(System.out::println);
        }
    }

    @Test
    public void testOutProcedure() throws SQLException {
        try (CallableStatement statement = connection.prepareCall("CALL get_total_user_count(?)")) {
            statement.registerOutParameter(1, Types.INTEGER);
            statement.execute();
            int count = statement.getInt(1);
            System.out.println("用户个数是：" + count);
        }

    }

    @Test
    public void testDataSource() throws SQLException {
        MysqlConnectionPoolDataSource dataSource = new MysqlConnectionPoolDataSource();
        dataSource.setUrl(JdbcUtil.URL);
        dataSource.setUser(JdbcUtil.USERNAME);
        dataSource.setPassword(JdbcUtil.PASSWORD);
        dataSource.setUseSSL(false);
        Connection connection = dataSource.getConnection();
        assertThat(connection, notNullValue());
    }
}
