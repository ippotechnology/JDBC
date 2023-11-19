package com.com.ippotechnology;

import java.sql.*;
import java.util.Scanner;

public class JDBCPreparedStatementDemo02 {
    public static void main(String[] args) {


        Connection connection = null;
        PreparedStatement preparedStatement= null;
        ResultSet resultSet= null;


        try {
            // 1 注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2 获取连接
            String url = "jdbc:mysql://127.0.0.1:3306/ippotechnology";
            String username = "root";
            String password = "root";
            connection = DriverManager.getConnection(url, username, password);
            // 3 获取数据库预编译操作对象
            String sqlSelect = "select id from users where name = ?";
            preparedStatement = connection.prepareStatement(sqlSelect);

            // 用户输入信息
             Scanner scanner = new Scanner(System.in);
             String strName = scanner.next();

            // 4 执行增删改Sql语句
            preparedStatement.setString(1,strName);
            resultSet = preparedStatement.executeQuery();

            // 5 查询结果集处理
            if (resultSet.next()) {
                System.out.println("登录成功");
            }else {
                System.out.println("登录失败");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 6 ???源
            try {
                if (resultSet != null) {
                    resultSet.close();
                } ;
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
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
