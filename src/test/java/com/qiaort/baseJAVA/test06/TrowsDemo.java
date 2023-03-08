package com.qiaort.baseJAVA.test06;
import java.io.*;
import java.util.Properties;

public class TrowsDemo {
    public static void main(String[] args) throws IOException {
        String filepath="src/main/resources/log4j.properties";
        LoadProperties2(filepath);
    }

    private static void LoadProperties1(String filepath) throws IOException {
        File file=new File(filepath);
        //将文件内容读取到输入流
        InputStream inputStream=new FileInputStream(file);
        Properties properties=new Properties();
        properties.load(inputStream);
        System.out.println(properties.getProperty("log4j.rootLogger"));
    }
    private static void LoadProperties2(String filepath) {
        File file=new File(filepath);
        //将文件内容读取到输入流
        InputStream inputStream= null;
        Properties properties=null;
        try {
            inputStream = new FileInputStream(file);
              properties=new Properties();

            properties.load(inputStream);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
            //捕捉到异常后的后续操作
        }
        finally{
            if(inputStream!=null){
                try {
                    inputStream.close();
                }catch (IOException e){
                    System.out.println("inputStrem不为空");
                }
            }
            else{
                System.out.println("inputStream为空");
            }
        }

        System.out.println(properties.getProperty("log4j.rootLogger"));
    }
}
