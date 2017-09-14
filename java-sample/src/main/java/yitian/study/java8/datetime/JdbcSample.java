package yitian.study.java8.datetime;

import java.sql.*;
import java.time.LocalDate;
import java.util.Objects;

public class JdbcSample {
    public static void main(String[] args) throws SQLException {
        //使用H2嵌入式内存数据库
        String url = "jdbc:h2:mem:test";
        try (Connection connection = DriverManager.getConnection(url)) {
            //创建表
            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE person(id INT PRIMARY KEY,name VARCHAR(255),birthday DATE)");

            //插入数据
            PreparedStatement p = connection.prepareStatement("INSERT INTO person VALUES(?,?,?)");
            p.setInt(1, 1);
            p.setString(2, "zhang3");
            p.setObject(3, LocalDate.of(1993, 5, 25));
            p.executeUpdate();

            //查询数据
            ResultSet rs = statement.executeQuery("SELECT *FROM person WHERE id=1");
            rs.next();
            Person person = new Person();
            person.setId(rs.getInt(1));
            person.setName(rs.getNString(2));
            person.setBirthday(rs.getObject(3, LocalDate.class));

            System.out.println("数据库中:" + person);
        }
    }
}

class Person {
    private int id;
    private String name;
    private LocalDate birthday;

    public Person() {
    }

    public Person(int id, String name, LocalDate birthday) {

        this.id = id;
        this.name = name;
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id &&
                Objects.equals(name, person.name) &&
                Objects.equals(birthday, person.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, birthday);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Person{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", birthday=").append(birthday);
        sb.append('}');
        return sb.toString();
    }
}
