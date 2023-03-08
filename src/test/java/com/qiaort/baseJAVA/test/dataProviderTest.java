package com.qiaort.baseJAVA.test;
import org.testng.annotations.DataProvider;

public class dataProviderTest {
    @DataProvider
    public Object[][] getUsersData(){
        Object[][] objects={
                {"billy","123"},
                {"dingxm3","123456"},
        };
        return objects;
    }

}
