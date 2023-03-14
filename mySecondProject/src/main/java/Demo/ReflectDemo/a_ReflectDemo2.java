package Demo.ReflectDemo;

import Demo.ExcelUtil;
import Demo.HttpUtil;
import com.alibaba.fastjson.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;


public class a_ReflectDemo2 {



    @Test(dataProvider ="data")
    public void login(String CaseId,String apiId,String parameters,String ExpectedResponseData,String ActualResponseData) throws IOException {
        String url = RestUtil.getUrlByApiId(apiId);
        String doMethod =RestUtil.getTypeByApiId(apiId);
        //需要参数
        Map<String,String> params= (Map<String,String>) JSONObject.parse(parameters);
        String result= HttpUtil.service(url,doMethod,params);
        System.out.println(result);
        WriteBackData writeBackData=new WriteBackData("用例",CaseId,"ActualResponseData",result);
        //ExcelUtil.writeBackData("src/main/resources/a_Reflect_case.xlsx","用例",CaseId,"ActualResponseData",result);
        ExcelUtil.writeBackDatas.add(writeBackData);
    }

    @DataProvider
    public Object[][] data(){
        String cellsName[] = {"CaseId","ApiId","Params","ExpectedResponseData","ActualResponseData"};
        Object[][] datas =CaseUtil.getCaseDataByApiId("1", cellsName);
        return datas;
    }
}
