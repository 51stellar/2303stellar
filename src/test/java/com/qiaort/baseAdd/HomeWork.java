package com.qiaort.baseAdd;

import java.util.*;

public class HomeWork {
    public static void main(String[] args) {

    }
    public void test1(){
        Map<String,List<Student>> map=new HashMap<String,List<Student>>();
        List<Student> lists=new ArrayList<Student>();
        Student studentA=new Student("笑话1","23","run1");
        lists.add(studentA);
        Student studentB=new Student("笑话2","24","run2");
        lists.add(studentB);
        Student studentC=new Student("笑话3","25","run3");
        lists.add(studentC);
        String className="1801";
        map.put(className,lists);
        Set <String> set=map.keySet();
        for(String s:set){
            List<Student> list1=map.get(s);
            for(Student t:list1){
                System.out.println(t);
            }
        }
    }
    public void test2(){
        Student studentD=new Student("笑话4","26","run4");
        Student studentE=new Student("笑话5","27","run5");
        String className="1802";
    }
}
