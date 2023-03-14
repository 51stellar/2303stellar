package Demo;

import com.alibaba.fastjson.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

import java.util.Map;
import java.util.Set;


public class a_PostDemo3 {



    @Test(dataProvider ="datas")
    public void test1(String parameters) throws IOException {

        Map<String,String> params= (Map<String,String>) JSONObject.parse(parameters);
        Set<String> paramsNames=params.keySet();
        for(String paramName:paramsNames){
            System.out.println("key="+paramName+"value="+params.get(paramName));
        }

     //   System.out.println( HttpUtil.doPost(url,params));

    }
    @DataProvider
    public Object[][] datas(){
        int rows[]={2,3,4,5,6};
        int cells[]={6};
        Object[][] objects=ExcelUtil.datas2("src/main/resources/test2.xlsx","用例",rows,cells);
        for(Object[] data:objects){
            for(Object aa: data) {
                System.out.print("[" + aa + "]");
            }
            System.out.println();
        }
        return objects;
    }

}
