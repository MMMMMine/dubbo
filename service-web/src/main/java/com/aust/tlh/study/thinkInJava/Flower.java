package com.aust.tlh.study.thinkInJava;

/**
 * 类描述:
 * Created by tanglinhui on 2017/2/8.
 * Version 1.0
 */
public class Flower {
    int petalCount = 0;
    String s = "initial value";

    Flower(int petals){
        this.petalCount = petals;
        System.out.println("Constructer w/ int arg only ,petalCount =" + petalCount);
    }

    Flower(String ss){
        System.out.println("Constructer w/ String arg only , s =" +ss);
        s= ss;
    }

    Flower(String s ,int petals){
        this(petals);
       // this(s); 不能调用2个
        this.s = s;
        System.out.println("String & int args");
    }

    Flower(){
        this("hi",47);
        System.out.println("default constructer (no args)");
    }

    void printPetalCount(){
     //   this(11); 不能再非构造函数中调用构造函数
        System.out.println("petalCount = "+petalCount +",s =" +s);
    }

    public static void main(String[] args) {
        Flower x = new Flower();
        x.printPetalCount();
    }
}
