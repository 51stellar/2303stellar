package com.qiaort.baseJAVA.test03;

import java.util.ArrayList;

public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<String> list=new ArrayList<String>();
        //增加数值
        list.add("张三");
        list.add("王五");
        list.add("李四");
        //打印长度
//        System.out.println(list.size());
//        //获取数据
//        System.out.println(list.get(2));
//        //删除数据
//        list.remove(0);
        String data=list.remove(0);
        System.out.println(data);
        System.out.println(list.get(0));
        list.set(0,"千寻");
        System.out.println(list.get(0));
        System.out.println(list.contains("qianxuan"));
        for(String str: list){
            System.out.println(str);
        }

    }
}
