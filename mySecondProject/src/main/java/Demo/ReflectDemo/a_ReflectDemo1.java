package Demo.ReflectDemo;

import Demo.ExcelUtil;
import Demo.HttpUtil;
import com.alibaba.fastjson.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;


public class a_ReflectDemo1 {



    @Test(dataProvider ="data")
    public void login(String apiId,String parameters) throws IOException {
        String url = RestUtil.getUrlByApiId(apiId);
        String doMethod =RestUtil.getTypeByApiId(apiId);
        //需要参数
        Map<String,String> params= (Map<String,String>) JSONObject.parse(parameters);
        String result= HttpUtil.service(url,doMethod,params);
        System.out.println(result);

    }

    @DataProvider
    public Object[][] data(){
        String cellsName[] = {"ApiId","Params"};
        Object[][] datas =CaseUtil.getCaseDataByApiId("1", cellsName);
        return datas;
    }
}
