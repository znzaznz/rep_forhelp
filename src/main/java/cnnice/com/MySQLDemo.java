package cnnice.com;

import java.sql.*;

public class MySQLDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 注册mysql
//        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://127.0.0.1:3306/learn";
        String root = "root";
        String password = "123456";

        // 获取连接
        Connection connection = DriverManager.getConnection(url, root, password);

        // sql操作
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * from student");

        // 输出结果
        while (rs.next()) {
            System.out.println(rs.getString("name"));
        }

        // 关闭
        rs.close();
        statement.close();
        connection.close();
    }
}
