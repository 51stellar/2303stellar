package com.mysql;

import java.sql.*;

public class Test {
    public static void main(String[] args) {
        String dbName = "pv";
        String url="jdbc:mysql://localhost:3306?"+dbName+"&serverTimezone=Asia/Shanghai";
        System.out.println(url);
        String username = "root";
        String password = "admin";
        try {
            // 驱动连接mysql-connect
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            String sql = "select * from pv.project";
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                String string = resultSet.getString(2);
                String name = resultSet.getString("name");
                Date create_time = resultSet.getDate("create_time");
                System.out.println(string);
                System.out.println(name);
                System.out.println(create_time);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
