package com.com.ippotechnology;
import java.sql.*;

public class JDBCSelectDemo{
    public static void main(String[] args) {

        Statement statement = null;
        Connection connection = null;
        ResultSet resultSet= null;

        try {
            // 1 注册??
            //Driver driver = new com.mysql.cj.jdbc.Driver();
            // DriverManager.registerDriver(driver);
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2 ?取?接
            String url = "jdbc:mysql://127.0.0.1:3306/ippotechnology";
            String username = "root";
            String password = "root";
            connection = DriverManager.getConnection(url, username, password);
            // 3 ?取数据?操作?象
            statement = connection.createStatement();

            //  4 ?行Sql?句
            String sqlSelect = "select *from users";
            resultSet = statement.executeQuery(sqlSelect);

            // 5 ?理?果集
            if (resultSet.next()) {
                String id =resultSet.getString("id");
                String name =resultSet.getString("name");
                System.out.println(id);
                System.out.println(name);
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

