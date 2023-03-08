package com.qiaort.baseJAVA.test03;

import org.checkerframework.checker.units.qual.K;

import java.util.HashMap;

public class HashMapDemo {
    public static void main(String[] args) {
        HashMap<String,String> map=new HashMap<String,String>();
        //增加值
        map.put("name","名扬");
        map.put("age","18");
        String age=map.get("age");
        System.out.println(age);

        //查看个数
        System.out.println(map.size());
        //删除
       String name= map.remove("name");
       //包含
        map.containsKey("name");
        map.containsValue("18");
        //取出所有key，value 迭代拿出所有键值对  entrySet方法


    }
}
