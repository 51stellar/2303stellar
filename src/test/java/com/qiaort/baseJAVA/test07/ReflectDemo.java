package com.qiaort.baseJAVA.test07;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ReflectDemo {
    public static void main(String[] args) throws DocumentException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String path="src/main/resources/student";
       List<Student> students=parseXml(path);
       for(Student student:students){
           System.out.println(student);
       }
    }
    private static List<Student> parseXml(String path) throws DocumentException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        List<Student> studentList=new ArrayList<Student>();
        //创建解析器SAXReader对象
        SAXReader reader = new SAXReader();
        //获取document对象
        Document document = reader.read(new File(path));
        //获取根元素
        Element rootElement = document.getRootElement();
        //获取根元素下的子元素
        List<Element> studentElements = rootElement.elements("student");
        for (Element student : studentElements) {
            Class<Student> clazz = Student.class;
            Student student1 = clazz.newInstance();
            List<Element> elements=student.elements();
            for(Element element:elements) {
                String setMethodname = "set"+element.getName();
                String getMethodname = "get"+element.getName();

                Method setMethod =clazz.getMethod(setMethodname,String.class);
                setMethod.invoke(student1,element.getText());
                Method getMethod=clazz.getMethod(getMethodname);
                Object object=getMethod.invoke(student1);
                System.out.println(object.toString());
            }
            studentList.add(student1);
        }
        return studentList;
    }

        }
