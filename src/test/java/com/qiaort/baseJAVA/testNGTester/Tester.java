package com.qiaort.baseJAVA.testNGTester;

import org.testng.Assert;
import org.testng.annotations.*;

public class Tester {
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Tester.beforeSuite()");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Tester.beforeMethod()");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("Tester.beforeClass()");
    }

//测试用例
    @BeforeTest
    public void beforeTest(){
        System.out.println("Tester.beforeTest()");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("Tester.afterMethod()");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("Tester.afterSuite()");
    }
    @Test
    public void test(){
        Calculator calculator=new Calculator();
        int actual=calculator.add(2,5);
        int expected=7;
        //断言如果两个一致，断言通过，不一致抛出断言错误
       Assert.assertEquals(actual,expected);
       System.out.println("Tester()");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("Tester.afterTest()");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("Tester.afterClass()");
    }

}
