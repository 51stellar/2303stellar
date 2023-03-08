package com.qiaort.baseJAVA.test02;
//字符串的用法
public class StringDemo {
    public static void main(String[] args) {
        String name="广东省深圳市南山区";
        String title="aVSDFSD-eee";
        String address="192.163.1.1";
        //截取字符串
        System.out.println(name.substring(0,3));
        if (name.equals("广东省深圳市南山区")){
            System.out.println("广东省深圳市南山区比对成功");
        }
        if (title.equalsIgnoreCase("aVSDFSD-eEE")){
            System.out.println("equalsIgnoreCase比对成功");

        }
        if(name.contains("广东省深圳")){
            System.out.println("contains比对成功");
        }
        System.out.println(name.indexOf("省"));
        System.out.println(title.lastIndexOf("e"));
        System.out.println(title.isEmpty());

        System.out.println(title.toUpperCase());
        System.out.println(title.toLowerCase());
        System.out.println(title.charAt(3));
//按照某个正则表达式来切分字符串
        String[] strings=address.split("\\.");
        for(String str:strings){
            System.out.println(str);
        }

        }

    }

