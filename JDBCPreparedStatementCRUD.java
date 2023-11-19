package com.com.ippotechnology;

import java.sql.*;


public class JDBCPreparedStatementCRUD {
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

            // 3 获取数据库预编译操作对象 增加
            String sqlInsert = "insert into users(id,name) values (?,?)";
            preparedStatement = connection.prepareStatement(sqlInsert);
            preparedStatement.setInt(1,2);
            preparedStatement.setString(2,"ippotechnology");
            preparedStatement.executeUpdate();

            // 3 获取数据库预编译操作对象 删除
            String sqlDelete = "delete from users  where id = ? ";
            preparedStatement = connection.prepareStatement(sqlDelete);
            preparedStatement.setInt(1,2);
            preparedStatement.executeUpdate();

            // 3 获取数据库预编译操作对象 修改
            String sqlUpdate = "update users set name=? where id=? ";
            preparedStatement = connection.prepareStatement(sqlUpdate);
            preparedStatement.setString(1,"ippotechnology");
            preparedStatement.setInt(2,1);
            preparedStatement.executeUpdate();


            String sqlSelect = "select * from users ";
            preparedStatement = connection.prepareStatement(sqlSelect);

            // 4 执行增删改查Sql语句
            resultSet = preparedStatement.executeQuery();

            // 5 查询结果集处理
            if (resultSet.next()) {
             int id = resultSet.getInt("id");
             String name=resultSet.getString("name");
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
