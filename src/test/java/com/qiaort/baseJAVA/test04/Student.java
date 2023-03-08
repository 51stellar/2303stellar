package com.qiaort.baseJAVA.test04;

public class Student {
    private static String name;
    private  static int age;
    private  static String gender;

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
    public Student(String name, int age, String gender){
        this.name=name;
        this.age=age;
        this.gender=gender;
    }
    public String toString(){
       return "name="+this.name+"age="+this.age+"gender="+this.gender;
    }
}
