package com.qiaort.baseJAVA.test06;

import java.util.ArrayList;
import java.util.List;

public class ExceptionDemo2 {
    public static void main(String[] args) {

        // NullPointerException 空指针异常
       // List<String> names=null;
        List<String> names=new ArrayList<>();
        names.add("lily");
        names.add("222");
        //indexOutOfBoundsException //越界异常
        System.out.println(names.get(2));
    }
}
