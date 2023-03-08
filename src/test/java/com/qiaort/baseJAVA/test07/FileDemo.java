package com.qiaort.baseJAVA.test07;

import java.io.File;

public class FileDemo {

    public static void main(String[] args) {
        //判断目录是否存在
        String path1="E:\\workplace\\ali";
        File file=new File(path1);
        System.out.println(file.exists());
        //创建目录
        file.mkdirs();
        //创建文件   file.createNewFile();
        //判断是否为目录 file.isDirectory();
    }
}
