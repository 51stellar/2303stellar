package com.qiaort.baseJAVA.testNGTester;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo {
   // @Test(dataProvider = "dataProvider1")
    @Test(dataProvider = "bb")
    public void run(String name,int age,String gender){
        System.out.println("name="+name+"age="+age+"gender="+gender);

    }


    /**
     * 同时提供多组测试数据
     * @return
     */
    @DataProvider
    public Object[][] dataProvider1(){
        Object [][] datas={
                {"秋1",22,"男"},
                {"椿1",21,"女"}
        };
        return datas;
    }
    @DataProvider(name="bb")
    public Object[][] dataProvider2(){
        Object [][] datas={
                {"秋2",22,"男"},
                {"椿2",21,"女"}
        };
        return datas;
    }
}
