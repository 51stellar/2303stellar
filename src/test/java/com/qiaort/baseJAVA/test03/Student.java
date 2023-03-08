package com.qiaort.baseJAVA.test03;

public class Student {
    private String name;
    private int age;
    private String gender;

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }
    public Student(String name,int age,String gender){
        this.name=name;
        this.age=age;
        this.gender=gender;
    }
}
