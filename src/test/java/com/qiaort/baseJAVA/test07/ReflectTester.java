package com.qiaort.baseJAVA.test07;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectTester {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //获取类的字节码
        Class<Student> clazz=Student.class;
        //通过字节码调用newInstance方法创建对象，底层其实调用的是字节码对应类中默认构造方法
        Student student=clazz.newInstance();
        //通过反射获取想要的方法
        Method methodSetName=clazz.getMethod("setName", String.class);
        //通过反射完成方法的调用
        methodSetName.invoke(student,"大鱼海棠");
        Method methodGetName=clazz.getMethod("getName");
        Object name=methodGetName.invoke(student);
        System.out.println(name.toString());

    }
}
