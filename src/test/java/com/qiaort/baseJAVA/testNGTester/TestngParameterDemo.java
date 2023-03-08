package com.qiaort.baseJAVA.testNGTester;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestngParameterDemo {
    /**
    此方法能够根据浏览器类型来
     */
    @Test
    @Parameters(value = {"browserType"})
    public void run(String browserType){
        System.out.println("browserType="+browserType);

    }
}
