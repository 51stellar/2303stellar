package com.mysql;

import java.io.*;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class JDBCUtil {

    public static Properties properties=new Properties();
    static{
        //从properties中解析文件，解析一次就可，不能频繁启动IO流
        String path="src/main/resources/jdbcProperties";
        InputStream inputStream=null;
        try {
            inputStream=new FileInputStream(new File(path));

            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //可变参数Object ...values
    public static  Map<String,Object> query(String sql,Object ...values) throws IOException, SQLException {

        Connection connection = getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
       Map<String, Object> map=new HashMap<>();
       for(int i=0;i<values.length;i++){
           preparedStatement.setObject(i+1,values[i]);
       }
       //getMetaData方法是为了获取原始sql的查询项
       ResultSetMetaData resultSetMetaData=preparedStatement.getMetaData();
       //使用getColumnCount方法获取原始sql查询项的总数
       int count=resultSetMetaData.getColumnCount();

       ResultSet resultSet=preparedStatement.executeQuery();
        while(resultSet.next()){
            for(int i=1;i<=count;i++){
              String itemName= resultSetMetaData.getColumnLabel(i);
              String itemData=resultSet.getObject(itemName).toString();
              map.put(itemName,itemData);
            }
        }
        return map;
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(properties.getProperty("url"),properties.getProperty("user"),properties.getProperty("password"));
    }
}
