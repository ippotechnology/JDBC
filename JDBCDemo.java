package com.com.ippotechnology;
import java.sql.*;

public class JDBCDemo{
    public static void main(String[] args) {

        Statement statement = null;
        Connection connection = null;
        ResultSet resultSet= null;

        try {
            // 1 注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2 获取连接
            String url = "jdbc:mysql://127.0.0.1:3306/ippotechnology";
            String username = "root";
            String password = "root";
            connection = DriverManager.getConnection(url, username, password);
            // 3 获取数据库操作对象
            statement = connection.createStatement();

            // 4 执行增删改Sql语句

           // String sqlInsert = "insert into  users values(1,'ippotechnology')";
           // int count = statement.executeUpdate(sqlInsert);

           // String sqlDelete = "delete from  users where id = 1";
          //  int count = statement.executeUpdate(sqlDelete);

          //  String sqlUpdate = "update users set name='IppoTechnology' where id = 1";
          //  int count = statement.executeUpdate(sqlUpdate);


            String sqlSelect = "select *from users";
            resultSet = statement.executeQuery(sqlSelect);

            // 5. 查询结果集处理
            if (resultSet.next()) {
                String id =resultSet.getString("id");
                String name =resultSet.getString("name");
                System.out.println(id);
                System.out.println(name);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 6 关闭资源
            try {
                if (resultSet != null) {
                    resultSet.close();
                } ;
            } catch (SQLException e) {
                e.printStackTrace();
            }

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

