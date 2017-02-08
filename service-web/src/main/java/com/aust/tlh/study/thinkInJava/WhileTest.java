package com.aust.tlh.study.thinkInJava;

import java.util.Random;

/**
 * 类描述:
 * Created by tanglinhui on 2017/2/7.
 * Version 1.0
 */
public class WhileTest {

   static boolean condition(){
       double random = Math.random();
       System.out.println("random:"+random);
        if (random<0.99)
            return true;
        return false;
    }

    public static void main(String[] args) {



    }
}
