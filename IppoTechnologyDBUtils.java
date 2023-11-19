package com.com.ippotechnology;

import java.sql.*;
import java.util.ResourceBundle;

public class IppoTechnologyDBUtils {


    private IppoTechnologyDBUtils() {
    }

    public static final ResourceBundle resourceBundle = ResourceBundle.getBundle("db");

    static {
        try {
            String dirver= resourceBundle.getString("driver");
            Class.forName(dirver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        // 2 获取连接
        String url= resourceBundle.getString("url");
        String username=resourceBundle.getString("username");
        String password=resourceBundle.getString("password");
        return  DriverManager.getConnection(url, username, password);
    }

    public  static void close(Connection conn, Statement st,ResultSet rs){
        try {
            if (rs != null) {
                rs.close();
            } ;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (st != null) {
                st.close();
            } ;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (conn != null) {
                conn.close();
            } ;
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
