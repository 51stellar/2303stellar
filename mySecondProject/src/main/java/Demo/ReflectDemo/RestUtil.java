package Demo.ReflectDemo;

import Demo.ExcelUtil;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class RestUtil {
    public static List<Rest> rests = new ArrayList<Rest>();

    //将所有数据解析封装到cases
    static {
        ExcelUtil.load("src/main/resources/a_Reflect_case.xlsx", "接口",Rest.class);

    }

    /*    根据接口编号，拿取对应接口URL
     */
    public static String  getUrlByApiId(String ApiId) {
        for(Rest rest:rests){
            if(rest.getApiId().equals(ApiId)){
                return rest.getUrl();
            }
        }
        return "";
    }
    /*    根据接口编号，拿取对应接口请求方式
     */
    public static String  getTypeByApiId(String ApiId) {
        for(Rest rest:rests){
            if(rest.getApiId().equals(ApiId)){
                return rest.getType();
            }
        }
        return "";
    }


    public static void main(String[] args) {
       for(Rest rest:rests){
           System.out.println(rest);
       }
    }
}
