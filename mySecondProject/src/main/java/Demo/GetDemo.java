package Demo;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class GetDemo {
    public static void main(String[] args) throws IOException {
        //提供接口地址,准备测试数据
        String data1="";
        String data2="";
        HashMap<String,String> params=new HashMap<String,String>();
        params.put(data1,data1);
        params.put(data2,data2);
        String url="";
        String result=HttpUtil.doGet(url,params);

    }

}
