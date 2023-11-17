package com.com.ippotechnology;
import java.sql.*;

public class JDBCInsertDemo {
    public static void main(String[] args) {

        Connection connection = null;
        Statement statement = null;
        
        try {
            // 1 注册驱动
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);

            // 2 获取连接
            String url = "jdbc:mysql://127.0.0.1:3306/ippotechnology";
            String username = "root";
            String password = "root";
            connection = DriverManager.getConnection(url, username, password);
            // 3 获取数据库操作对象
            statement = connection.createStatement();


            // 4 执行增删改Sql语句
            String sqlInsert = "insert into  users values(1,'ippotechnology')";
            int count = statement.executeUpdate(sqlInsert);
            System.out.println(count==1?"添加数据成功":"添加数据失败");

            // 5. 若有查询语句则结果集处理
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 6 关闭资源
            
            try {
                if (statement != null) {
                    statement.close();
                } ;
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (connection != null) {
                    connection.close();
                } ;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}

