package com.qiaort.baseJAVA.test06;

import java.io.*;
import java.util.Properties;

public class ExceptionDemo1 {
    public static void main(String[] args)  {
        Properties properties=new Properties();
        //根据文件路径创建文件对象
        File file=new File("src/main/resources/log4j.properties");
        //FileNotFoundException 编译时异常
        try {
            InputStream inputStream = new FileInputStream(file);
            //调用load方法从输入流中加载数据到对象
            //IOException
            properties.load(inputStream);
        }catch (Exception e){
            System.out.println("properties解析出错");
        }
        System.out.println(properties.getProperty("log4j.rootLogger"));

    }
}
