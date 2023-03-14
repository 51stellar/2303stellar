package Demo;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class PostDemo {
    public static void main(String[] args) throws IOException {
        //填写接口地址
      String url="https://mail.midea.com/coremail/s/json?sid=HArXjZLLznTXeCWsuDLLLfIxrKptMXxL&func=user%3AgetAttrs";
      //指定接口请求方式
        HttpPost post=new HttpPost(url);
        //准备测试数据【参数】
        String js="{\"attrIds\":[\"email\",\n" +
                "\"primary_email\",\n" +
                "\"true_name\",\n" +
                "\"gender\",\n" +
                "\"@ou\",\n" +
                "\"safelist\",\n" +
                "\"refuselist\"],\"optionalAttrIds\":[\"firstpage\",\n" +
                "\"save_sent\",\n" +
                "\"edit_mode\",\n" +
                "\"aftersend_saveaddr\",\n" +
                "\"maxlist\",\n" +
                "\"addo\",\n" +
                "\"replyf\",\n" +
                "\"afterdel\",\n" +
                "\"displaysender\",\n" +
                "\"smtp_save_sent\",\n" +
                "\"op_readreceipt\",\n" +
                "\"newwindowtoreadletter\",\n" +
                "\"clock_system\",\n" +
                "\"display_list\",\n" +
                "\"display_size\",\n" +
                "\"list_brief_text\",\n" +
                "\"reference_content\",\n" +
                "\"preview_layout\",\n" +
                "\"list_style\",\n" +
                "\"shortcut\",\n" +
                "\"send_card\",\n" +
                "\"search_ordering_rule\",\n" +
                "\"index_time_category\",\n" +
                "\"multi_tab\",\n" +
                "\"reply_all_mode\",\n" +
                "\"query_read_status\",\n" +
                "\"time_zone\",\n" +
                "\"def_sec_folder\",\n" +
                "\"ws_msg_notify\",\n" +
                "\"ws_msg_notify_folder\",\n" +
                "\"default_sender_address\",\n" +
                "\"signature_position\",\n" +
                "\"sms_login_notify\",\n" +
                "\"app_login_notify\",\n" +
                "\"subject_refw_prefix_expand\",\n" +
                "\"migration_progress\",\n" +
                "\"event_notify_options\",\n" +
                "\"translate\",\n" +
                "\"translate_condition\"]}";
        //准备请求头信息
        post.setHeader("Content-Type","text/x-json");
        post.setHeader("Cookie","uid=qiaort; locale=zh_CN; CoremailReferer=https%3A%2F%2Fmail.midea.com%2Fcoremail%2Findex.jsp%3Fcus%3D1; Coremail.sid=HArXjZLLznTXeCWsuDLLLfIxrKptMXxL; Coremail=1bb7adca3867442ec747da19b90df1c1");
        StringEntity se=new StringEntity(js);
     //   se.setContentType(CONTENT_TYPE_TEXT_JSON);
        post.setEntity(se);
        //发起请求：获取响应信息
        HttpClient client= HttpClients.createDefault();
        HttpResponse response=client.execute(post);
        //状态码
        int code=response.getStatusLine().getStatusCode();
        System.out.println(code);
        String result= EntityUtils.toString(response.getEntity());
        System.out.println(result);
    }
}
