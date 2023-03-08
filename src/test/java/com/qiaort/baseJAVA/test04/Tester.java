package com.qiaort.baseJAVA.test04;

public class Tester extends Parent{
    static{
        System.out.println("静态代码块");
    }
    //静态代码块
    //Tester.main()
    //Parent.Parent()
    //Tester.tester()
    //tester.sayHi()
    public static void main(String[] args) {
     System.out.println("Tester.main()");
     Tester tester=new Tester();
     tester.sayHi();


       Student student1=new Student("Lily",12,"female");
       Student student2=student1;
       student2.setName("kangkang");
      System.out.println(student1);
      System.out.println(student2);
    }
    public Tester(){
        System.out.println("Tester.tester()");
    }
    public void sayHi(){
        System.out.println("tester.sayHi()");
    }
}
