package com.qiaort.baseJAVA.test02;
//继承抽象类
public class Cooker extends v2 {
    @Override
    public void work() {
        System.out.println("烹饪");
    }
    public static  void main(String args[]){
        Cooker cooker=new Cooker();
        cooker.showDairly();
    }
}

