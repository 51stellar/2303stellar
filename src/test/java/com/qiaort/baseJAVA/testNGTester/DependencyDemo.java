package com.qiaort.baseJAVA.testNGTester;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DependencyDemo {
    @Test(dependsOnMethods = "a2")
    public void a1(){
        System.out.println("DependenyDemo.a1()");
    }
    @Test
    public void a2(){
        System.out.println("DependencyDemo.a2()");
    }
    @Test(enabled = false)
    public void a3(){
        System.out.println("DependencyDemo.a3()");
    }
    @BeforeMethod
    public void a4(){
        System.out.println("DependencyDemo.a4()");
    }
    @Test(timeOut = 1)
    public void test(){
        for(int i=0;i<100;i++){
            System.out.println(i);
        }
    }

}
