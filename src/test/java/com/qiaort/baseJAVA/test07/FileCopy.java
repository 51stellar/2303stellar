package com.qiaort.baseJAVA.test07;

import java.io.*;

public class FileCopy {
    public static void main(String[] args) throws IOException {
        String path1="C:\\Users\\Runting_PC\\Desktop\\13257145828914874.jpg";
        String path2="C:\\Users\\Runting_PC\\Desktop\\beauty.jpg";
        InputStream inputStream=new FileInputStream(new File(path1));
        OutputStream outputStream=new FileOutputStream(new File(path2));
        int size;
        while((size=inputStream.read())!=-1){
            outputStream.write(size);
        }
        if(inputStream!=null){
            inputStream.close();
        }
        if(outputStream!=null){
            outputStream.close();
        }
        System.out.println("finish");

    }
}
