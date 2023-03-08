package com.qiaort.baseJAVA.test02;
//既想保持差异化，又想拥有以实现方法继承使用，就使用抽象类
public abstract class v2 {
    public abstract void work();//定义抽象方法，就是为了实现子类的差异化
    public void showDairly(){
        System.out.print("起床");
        System.out.print("上班");
        work();
        System.out.print("睡觉");
    }
}
