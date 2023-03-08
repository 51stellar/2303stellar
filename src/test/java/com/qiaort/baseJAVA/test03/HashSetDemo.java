package com.qiaort.baseJAVA.test03;

import netscape.security.UserTarget;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class HashSetDemo {
    public static void main(String[] args) {
     HashSet<String> set=new HashSet<String>();
     set.add("11");
     set.add("222");
     set.add("333");
        set.add("333");
       Iterator<String> itor=set.iterator();
      while (itor.hasNext()){
          System.out.println(itor.next());
       }
     //把set转换为数组
//     Object[] boject=set.toArray();
//     for(Object o:boject){
//         System.out.println(o);
//     }
        //clear();清楚所有的值
//     set.clear();
//        System.out.println(set.size());
        System.out.println(set.size());
    }
}
