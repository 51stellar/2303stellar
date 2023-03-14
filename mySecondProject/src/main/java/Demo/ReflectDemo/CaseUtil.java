package Demo.ReflectDemo;

import Demo.ExcelUtil;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class CaseUtil {
    public static List<Case> cases = new ArrayList<Case>();

    //将所有数据解析封装到cases
    static {
        ExcelUtil.load("src/main/resources/a_Reflect_case.xlsx", "用例",Case.class);

    }

    /*    根据接口编号，拿取对应接口的测试数据
         @param apiId 指定接口编号
        @param   cellName  获取数据对应的列名

     */
    public static Object[][] getCaseDataByApiId(String ApiId, String cellsName[]) {
        //定义list接受apiId过滤的对象集合
        List<Case> lists = new ArrayList<Case>();
        for (Case data : cases) {
            //把符合要求的即：apiId相同的数据添加到list集合中
            if (ApiId.equals(data.getApiId())) {
                lists.add(data);
            }
        }
        //使用反射获取对象
        Class<Case> clazz = Case.class;
        //初始化返回的object数组
        Object[][] objects = new Object[lists.size()][cellsName.length];
        //构造返回的object[][]数组
        for (int i = 0; i < lists.size(); i++) {
            Case cs = lists.get(i);
            for (int j = 0; j < cellsName.length; j++) {
                String methodName = cellsName[j];
                methodName = "get" + methodName;
                try {
                    Method method = clazz.getMethod(methodName);
                    String value = (String) method.invoke(cs);
                    objects[i][j] = value;
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        }

        return objects;
    }

}
