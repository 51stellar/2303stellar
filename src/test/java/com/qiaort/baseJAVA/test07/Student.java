package com.qiaort.baseJAVA.test07;

public class Student {
    private String name;
    private String sport;
    private String age;
public Student(){

}

    public  Student(String name,String age,String sport){
        this.name=name;
        this.age=age;
        this.sport=sport;
    }


    public String getName() {
        return name;
    }

    public String getSport() {
        return sport;
    }

    public String getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public void setAge(String age) {
        this.age = age;
    }

 public String toString(){
        return "name="+name+"age="+age+"sport="+sport;
 }

}
