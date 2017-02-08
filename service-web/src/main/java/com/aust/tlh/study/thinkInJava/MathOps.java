package com.aust.tlh.study.thinkInJava;

import org.springframework.format.Printer;

import java.util.Random;

import static java.lang.System.*;

/**
 * 类描述:
 * Created by tanglinhui on 2017/2/7.
 * Version 1.0
 */
public class MathOps {
    public static void main(String[] args) {
        Random rand = new Random(47); //随机数生成器对于特定的种子值总是产生相同的随机数序列
        int i, j, k;
        j = rand.nextInt(100) + 1;
        out.println("j :" + j);
        k = rand.nextInt(100) + 1;
        out.println("k :" + k);
        i = j + k;
        out.println("j+k :" + i);
        i = j - k;
        out.println("j-k :" + i);
        i = k * j;
        out.println("k*j :" + i);
        i = k / j;
        out.println("k*j :" + i);
        i = k % j;
        out.println("k%j :" + i);
        j %= k;
        out.println("k%=j :" + j);
        float u, v, w;
        v = rand.nextFloat();
        out.println("v :" + v);
        w = rand.nextFloat();
        out.println("w :" + w);
        u = v + w;
        out.println("v+w :"+u);
        u = v - w;
        out.println("v-w :"+u);
        u = v - w;
        out.println("v-w :"+u);
        u += v;
        out.println("u+=v :"+u);
        u -= v;
        out.println("u-=v :"+u);
        u *= v;
        out.println("u*=v :"+u);
        u /= v;
        out.println("u/=v :"+u);
    }
}
