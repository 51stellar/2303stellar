package Demo;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.*;

public class HttpUtil {
    public static  String doPost(String url, Map<String, String> params) throws IOException {
        HttpPost httpPost=new HttpPost(url);
        List<BasicNameValuePair> parametes=new ArrayList<BasicNameValuePair>();
        Set<String> names=params.keySet();
        for(String name:names){
            parametes.add(new BasicNameValuePair(name,params.get(name)));
        }
        httpPost.setEntity(new UrlEncodedFormEntity(parametes,"utf-8"));
        HttpClient client= HttpClients.createDefault();
        HttpResponse httpResponse=client.execute(httpPost);
        int code=httpResponse.getStatusLine().getStatusCode();
        String result= EntityUtils.toString(httpResponse.getEntity());


        return result;
    }
    public static String doGet(String url, Map<String, String> params) throws IOException {
        Set<String> parameters=params.keySet();
        for(String name:parameters) {
            int mark = 1;
            if (mark == 1) {
                url += (url + "?" +name+"="+params.get(name));
                mark++;
            }else{
                url+=(url+"&"+name+"="+params.get(name));
            }
        }
        HttpGet httpGet=new HttpGet(url);
        HttpClient client=HttpClients.createDefault();
        HttpResponse response=client.execute(httpGet);
        String result=EntityUtils.toString(response.getEntity());


        return result;
    }
    public static String service(String url, String doService, Map<String,String> params) {

        try {
            if (doService.equals("post")) {
                //根据excel的请求方式，确定执行post操作，还是get操作，此处打印的是post
                return HttpUtil.doPost(url, params);
            } else if (doService.equals("get")) {
                //根据excel的请求方式，确定执行post操作，还是get操作，此处打印的是post
                return HttpUtil.doPost(url, params);
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}

