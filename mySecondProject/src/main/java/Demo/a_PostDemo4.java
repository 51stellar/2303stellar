package Demo;

import com.alibaba.fastjson.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class a_PostDemo4 {



    @Test(dataProvider ="datas1")
    public void test1(String sn,String parameters) throws IOException {
        Map<String,String> params= (Map<String,String>) JSONObject.parse(parameters);
        String url="";
        int rows[]={2,3,4,5};
        int cells[]={1,2};
        //获取接口表
        Object[][] objects=ExcelUtil.datas2("src/main/resources/test3.xlsx","用例",rows,cells);
        for(Object[] datas:objects){
            String CN=datas[0].toString();
            if(CN.equals(sn)){
                url=datas[1].toString();
                System.out.println(url);
                break;
            }
        }

     //   System.out.println( HttpUtil.doPost(url,params));

    }
    @DataProvider
    public Object[][] datas1(){
        int rows[]={2,3,4,5,6};
        int cells[]={5,6};
        Object[][] objects=ExcelUtil.datas2("src/main/resources/test2.xlsx","用例",rows,cells);
        for(Object[] data:objects){
            for(Object aa: data) {
                System.out.print("[" + aa + "]");
            }
            System.out.println();
        }
        return objects;
    }

    @DataProvider
    public Object[][] datas2(){
        int rows[]={2,3,4,5};
        int cells[]={1,2};
        Object[][] objects=ExcelUtil.datas2("src/main/resources/test3.xlsx","用例",rows,cells);
        for(Object[] data:objects){
            for(Object aa: data) {
                System.out.print("[" + aa + "]");
            }
            System.out.println();
        }
        return objects;
    }
}
