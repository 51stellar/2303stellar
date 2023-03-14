package Demo;

import com.alibaba.fastjson.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;


public class a_PostDemo5 {



    @Test(dataProvider ="testCase1")
    public void test1(String apiIDformCase,String parameters) throws IOException {
        String url = null,doMethod = null;
        int rows[]={2,3,4,5};
        int cells[]={1,2,4};
        //获取接口表
        Object[][] objects=ExcelUtil.datas2("src/main/resources/test3.xlsx","接口表",rows,cells);
        for(Object[] datas:objects){
            if(datas[0].toString().equals(apiIDformCase)) {
                url = datas[2].toString();
                doMethod = datas[1].toString();
            }
        }
                //需要参数
            Map<String,String> params= (Map<String,String>) JSONObject.parse(parameters);
                String result=HttpUtil.service(url,doMethod,params);
               System.out.println(result);


        }

    @DataProvider
    public Object[][] testCase1(){
        int rows[]={2,3,4,5,6,7};
        int cells[]={3,6};
        Object[][] objects=ExcelUtil.datas2("src/main/resources/test2.xlsx","用例",rows,cells);
//        for(Object[] data:objects){
//            for(Object aa: data) {
//                System.out.print("[" + aa + "]");
//            }
//            System.out.println();
//        }
        return objects;
    }

    @DataProvider
    public Object[][] datas2(){
        int rows[]={2,3,4,5};
        int cells[]={1,2,4};
        Object[][] objects=ExcelUtil.datas2("src/main/resources/test3.xlsx","接口表",rows,cells);
        for(Object[] data:objects){
            for(Object aa: data) {
                System.out.print("[" + aa + "]");
            }
            System.out.println();
        }
        return objects;
    }
}
