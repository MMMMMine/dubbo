package com.aust.tlh.study.thinkInJavaPra.controllingExecution;

import java.util.Random;
import static java.lang.System.*;

/**
 * 类描述:
 * Created by tanglinhui on 2017/2/7.
 * Version 1.0
 */
public class CompareInts {
    public static void main(String[] args) {
        Random rand1 = new Random();
        Random rand2 = new Random();
        for(int i = 0; i < 25; i++) {
            int x = rand1.nextInt();
            int y = rand2.nextInt();
            if(x < y) out.println(x + " < " + y);
            else if(x > y) out.println(x + " > " + y);
            else out.println(x + " = " + y);
        }
        Random rand3 = new Random();
        Random rand4 = new Random();
        for(int i = 0; i < 25; i++) {
            int x = rand3.nextInt(10);
            int y = rand4.nextInt(10);
            if(x < y) out.println(x + " < " + y);
            else if(x > y) out.println(x + " > " + y);
            else out.println(x + " = " + y);
        }


    }
}
