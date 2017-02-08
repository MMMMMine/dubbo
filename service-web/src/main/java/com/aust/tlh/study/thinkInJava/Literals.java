package com.aust.tlh.study.thinkInJava;

/**
 * 类描述:
 * Created by tanglinhui on 2017/2/7.
 * Version 1.0
 */
public class Literals {
    public static void main(String[] args) {
        long l1 = 0x223f; //十六进制
        System.out.println("l1: "+Long.toBinaryString(l1));
        long l2 = 0177123;//八进制
        System.out.println("l2: "+Long.toBinaryString(l2));

        double max = java.lang.Double.MAX_VALUE; //最大的double
        System.out.println("Max double = " + max);
        double min = java.lang.Double.MIN_VALUE;//最小的double
        System.out.println("Min double = " + min);
        float maxf = java.lang.Float.MAX_VALUE;//最大的float
        System.out.println("Max float = " + maxf);
        float minf = java.lang.Float.MIN_VALUE;//最小的float
        System.out.println("Min float = " + minf);
    }
}
