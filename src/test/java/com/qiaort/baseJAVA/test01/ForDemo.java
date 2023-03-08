package com.qiaort.baseJAVA.test01;

//输出正三角形状
//冒泡排序【4,1,3,2,5】按照从小到大顺序排列
public class ForDemo {
    public String age;
    public void setAge(String age){
        this.age=age+" ";
    }
    public String getAge(){
        return this.age;
    }
    public static void main(String args[]) {
        ForDemo demo=new ForDemo();
        int a[]={4,1,3,2,5,9,10};
        demo.maopao(a);
      //  demo.printSque(5);
    }
    //输出正三角形状
    public void printSque(int args){
        for(int i=1;i<=args;i++){

            for(int j=1;j<=args-i;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=i;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    //冒泡排序【4,1,3,2,5】按照从小到大顺序排列
    public void maopao(int a[]){
        int length=a.length;
        int temp;
        for(int i=length;i>0;i--){
            for(int j=0;j<=i-1;j++){
                if(a[i-1]<a[j]){
                    temp=a[i-1];
                   a[i-1]=a[j];
                   a[j]=temp;
            }
           }
        }
        for(int i=0;i<length;i++){
            System.out.print(a[i]);
        }
    }

}
