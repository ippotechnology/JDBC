package com.com.ippotechnology;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCTransactionDemo {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement= null;
        ResultSet resultSet= null;

        try {
            connection=IppoTechnologyDBUtils.getConnection();
            connection.setAutoCommit(false);
            connection.getAutoCommit();


            String sqlUpdate01 = "update account set price=price-? where name=? ";
            preparedStatement = connection.prepareStatement(sqlUpdate01);
            preparedStatement.setInt(1,1000);
            preparedStatement.setString(2,"a");
            preparedStatement.executeUpdate();

            int num=10/0;

            String sqlUpdate02 = "update account set price=price+? where name=? ";
            preparedStatement = connection.prepareStatement(sqlUpdate02);
            preparedStatement.setInt(1,1000);
            preparedStatement.setString(2,"b");
            preparedStatement.executeUpdate();

            connection.commit();


            String sqlSelect = "select *from account ";
            preparedStatement = connection.prepareStatement(sqlSelect);
            resultSet = preparedStatement.executeQuery();

            //  查询结果集处理
           while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name=resultSet.getString("name");
                int price = resultSet.getInt("price");
                System.out.println(id+"--->"+name+"--->"+price);
            }


        }catch (Exception e){
            try {
                if (connection != null) {
                    connection.rollback();
                } ;
            } catch (SQLException esql) {
                esql.printStackTrace();
            }

            e.printStackTrace();
        }finally {
            IppoTechnologyDBUtils.close(connection,preparedStatement,resultSet);
        }
    }
}
