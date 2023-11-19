package com.com.ippotechnology;

import com.com.ippotechnology.IppoTechnologyDBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class IppoTechnologyDBDemo {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement= null;
        ResultSet resultSet= null;

        try {
            connection= IppoTechnologyDBUtils.getConnection();

            String sqlSelect = "select * from users ";
            preparedStatement = connection.prepareStatement(sqlSelect);

            //  执行增删改查Sql语句
            resultSet = preparedStatement.executeQuery();
            //  查询结果集处理
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name=resultSet.getString("name");
                System.out.println(id);
                System.out.println(name);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            IppoTechnologyDBUtils.close(connection,preparedStatement,resultSet);
        }
    }
}