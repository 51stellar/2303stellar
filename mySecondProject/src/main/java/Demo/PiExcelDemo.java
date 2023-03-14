package Demo;


import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapters;
import java.io.IOException;
import java.util.HashMap;

public class PiExcelDemo {


    private void test1(){
        String url="http://10.16.70.40:8082/api/login";
        HashMap<String,String> params=new HashMap<String, String>();
        params.put("username","admin");
        params.put("password","rdmadmin");

        try {
            System.out.println( HttpUtil.doPost(url,params));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }





    }


