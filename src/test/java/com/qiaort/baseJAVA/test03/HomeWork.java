package com.qiaort.baseJAVA.test03;

import java.util.ArrayList;
import java.util.Iterator;

public class HomeWork {

    public static void main(String[] args) {
     Student student1=new Student("张三",25,"男");
     Student student2=new Student("千寻",8,"女");
     Student student3=new Student("汤婆婆",59,"男");
     ArrayList<Student> list=new ArrayList<Student>();
     list.add(student1);
        list.add(student2);
        list.add(student3);
        student1=list.get(0);
        student1.setName("111");
        for(Student student: list){
            System.out.println("name="+student.getName()+"gender="+student.getGender()+"age="+student.getAge());
        }
        Iterator<Student> iterator=list.iterator();
        if(iterator.hasNext()){
           Student Student=iterator.next();
            System.out.println("name="+Student.getName()+"gender="+Student.getGender()+"age="+Student.getAge());
        }
    }
}

