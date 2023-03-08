package com.qiaort.baseJAVA.test08;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**<?xml version="1.0" encoding="UTF-8" ?>
<page keyword="注册页">
<UIElement keyword="用户名" by="id" value="mobilephone"></UIElement>
<UIElement keyword="密码" by="id" value="password"></UIElement>
<UIElement keyword="重复密码" by="id" value="pwdconfirm"></UIElement>
<UIElement keyword="注册按钮" by="id" value="signup-button"></UIElement>
<UIElement keyword="错误提示" by="classname" value="tips"></UIElement>
</page>
 */
public class XmlUtilReflect {
    public static void main(String[] args) throws DocumentException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String path="src/main/resources/UILibrary";
        Page result=parse(path);
        System.out.println(result.getKeyword());
        List<Locator> lists=result.getLocators();
        for(Locator list:lists){
            System.out.println(list);
        }

    }

    private static Page parse(String path) throws DocumentException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        List<Locator> list=new ArrayList<Locator>();
        //获取类的字节码
        Class<Page> clazzPage=Page.class;
        //通过字节码newInstance方法new对象
        Page reflectPage=clazzPage.newInstance();
        //获取解析器
        SAXReader reader=new SAXReader();
        //获取根节点
        Document document=reader.read(new File(path));
        //通过根节点遍历子元素
        Element rootElement=document.getRootElement();
        //获取根元素的属性组，并循环调用set方法赋值
        List<Attribute> pageAttributes=rootElement.attributes();
        for(Attribute attribute:pageAttributes){
            String attributeName=attribute.getName();
            String lastName="set"+buildString(attributeName);
            String attributeValue=attribute.getValue();
            Method pageMethod=clazzPage.getMethod(lastName,String.class);
            pageMethod.invoke(reflectPage,attributeValue);
        }

        Class<Locator> clazz=Locator.class;
        List<Element> uiElements=rootElement.elements("UIElement");
        for(Element element:uiElements){
            Locator locator=clazz.newInstance();
            List<Attribute> attributes=element.attributes();
           for(Attribute attribute:attributes){
               String attributeName=attribute.getName();
               //获取method名字，set方法
               String buildMethodName="set"+buildString(attributeName);
               String MethodValue=attribute.getValue();
               Method method=clazz.getMethod(buildMethodName,String.class);
               method.invoke(locator,MethodValue);
           }
            list.add(locator);
        }
        //使用method方法调用List<Locator> 的set方法
       Method setList=clazzPage.getMethod("setLocators", List.class);
        setList.invoke(reflectPage,list);
                return reflectPage;
    }
    public static String buildString(String stringName){
        String name=stringName.substring(0,1).toUpperCase()+stringName.substring(1);
        return name;
    }
}
