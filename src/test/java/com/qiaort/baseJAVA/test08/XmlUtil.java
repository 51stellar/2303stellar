package com.qiaort.baseJAVA.test08;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
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
public class XmlUtil {
    public static void main(String[] args) throws DocumentException {
        String path="src/main/resources/UILibrary";
        Page result=parse(path);
        System.out.println(result.getKeyword());
        List<Locator> lists=result.getLocators();
        for(Locator list:lists){
            System.out.println(list);
        }

    }

    private static Page parse(String path) throws DocumentException {
        List<Locator> list=new ArrayList<Locator>();
        Page page=new Page();
        //获取解析器
        SAXReader reader=new SAXReader();
        //获取根节点
        Document document=reader.read(new File(path));
        //通过根节点遍历子元素
        Element rootElement=document.getRootElement();
        String pageKeyword=rootElement.attributeValue("keyword");
        page.setKeyword(pageKeyword);
        List<Element> uiElements=rootElement.elements("UIElement");
        for(Element element:uiElements){
            String keyword=element.attributeValue("keyword");
            String by=element.attributeValue("by");
            String value=element.attributeValue("value");
            Locator locator=new Locator();
            locator.setKeyword(keyword);
            locator.setBy(by);
            locator.setValue(value);
            list.add(locator);
        }
        page.setLocators(list);
                return page;
    }
}
