package Demo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.HashMap;

public class a_PostDemo2 {



    @Test(dataProvider ="datas")
    public void test1(String username, String password) throws IOException {

        String url="http://10.16.70.40:8082/api/login";
        HashMap<String,String> params=new HashMap<String, String>();
        params.put("username",username);
        params.put("password",password);

        System.out.println( HttpUtil.doPost(url,params));

    }
    @DataProvider
    public Object[][] datas(){
        Object[][] datas=ExcelUtil.datas1("1",1,5,5,6);
        for(Object[] data:datas){
            for(Object a: data) {
                System.out.print("[" + a + "]");
            }
            System.out.println();
        }
        return datas;
    }

}
