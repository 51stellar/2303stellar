package com.qiaort.baseAdd;

public class Student {
    private String studentAge;
    private String studentName;
    private String studentSport;

    public String getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(String studentAge) {
        this.studentAge = studentAge;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentSport() {
        return studentSport;
    }

    public void setStudentSport(String studentSport) {
        this.studentSport = studentSport;
    }
    public String toString(){
        return "age="+studentAge+"sport="+studentSport+"name="+studentName;
    }
    public  Student(String name,String StudentAge,String sport){
        this.studentName=name;
        this.studentSport=sport;
        this.studentAge=StudentAge;
    }
    public Student(){

    }
}
