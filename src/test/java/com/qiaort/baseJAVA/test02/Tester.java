package com.qiaort.baseJAVA.test02;

public class Tester {
    public void showWork(Worker worker){
        worker.work();
    }

    public static void main(String[] args) {
        Teacher teacher=new Teacher();
        Tester tester=new Tester();
        tester.showWork(teacher);
    }

}
