package com.qiaort.baseAdd;



import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Parse1 {
    public static void main(String[] args) throws DocumentException {
        Parse1 parse1=new Parse1();
        List<Student> lists= null;
        try {
            lists = parse1.Parse("src/main/resources/student");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        for(Student s:lists){
            System.out.println(s);
        }

    }
    public List<Student> Parse(String filePath) throws DocumentException, IllegalAccessException, InstantiationException {
        List<Student> students=new ArrayList<Student>();
     //获取解析器
        SAXReader saxReader=new SAXReader();
        //获取Document对象
        Document document=saxReader.read(new File(filePath));
        //获取根节点
        Element root=document.getRootElement();
        //根据根节点遍历字子节点
        List<Element> elementList=root.elements("student");
        //通过反射来调用student对象
        Class<Student> clazz=Student.class;
        for(Element e:elementList){
            //调用setStudentname方法来封装学生的名称

            Student student=clazz.newInstance();
            List<Element> childlist=e.elements();
            for(Element s:childlist){
                //转换字符串首字母大写，从setstudent到setStudentAge
                String value=s.getName().substring(0,1).toUpperCase()+s.getName().substring(1);
                String methodname="set"+value;
                String methodtext=s.getText();
                try {
                    Method method=clazz.getMethod(methodname,String.class);
                    //反射调用方法
                    method.invoke(student,methodtext);
                } catch (NoSuchMethodException noSuchMethodException) {
                    noSuchMethodException.printStackTrace();
                } catch (InvocationTargetException invocationTargetException) {
                    invocationTargetException.printStackTrace();
                }

            }
            students.add(student);


        }
      return students;
    }
}
