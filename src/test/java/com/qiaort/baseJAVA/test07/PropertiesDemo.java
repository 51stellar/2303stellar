package com.qiaort.baseJAVA.test07;

import java.io.*;
import java.util.Properties;

public class PropertiesDemo {
    public static void main(String[] args) {
        String filePath="src/main/resources/log4j.properties";
    }
    private static void loadProperties(String filePath) throws IOException {
        Properties properties=new Properties();
        InputStream inputStream=new FileInputStream(new File(filePath));
        properties.load(inputStream);
    }
}
