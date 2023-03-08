package com.qiaort.baseJAVA.test07;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

public class XmlDemo {
    public static void main(String[] args) throws DocumentException {
                   //src/main/resources
        String path="src/main/resources/student";
        parseXml(path);
    }

    private static void parseXml(String path) throws DocumentException {
        //创建解析器SAXReader对象
        SAXReader reader=new SAXReader();
        //获取document对象
        Document document=reader.read(new File(path));
        //获取根元素
        Element rootElement=document.getRootElement();
        //获取根元素下的子元素
        List<Element> studentElements=rootElement.elements("student");
        for(Element student:studentElements){
            Element name=student.element("Name");
            Element age=student.element("Age");
            Element sport=student.element("Sport");
            System.out.println(name.getText());
            System.out.println(age.getText());
            System.out.println(sport.getText());
        }
    }
}
