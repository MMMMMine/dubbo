package com.aust.tlh.study.thinkInJavaPra.controllingExecution;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 类描述:
 * Created by tanglinhui on 2017/2/7.
 * Version 1.0
 */
public class VampireNum {
    public static void main(String[] args) {

        for (int j = 10; j < 100; j++) {
            for (int k = j+1; k < 100; k++) {
                int i = j * k;
                if (i < 10000 && i > 1000) {
                    String[] array1 = (i + "").split("");
                    Arrays.sort(array1);
                    String[] array2 = (""+j + k).split("");
                    Arrays.sort(array2);
                    if (Arrays.equals(array1, array2)) {
                        System.out.println(j + "*" + k + "=" + i);
                    }
                }
            }
        }

        for (int i = 10; i <= 99; i++) {
            for (int j = i + 1; j <= 99; j++) {
                // 计算出所有两位数的积
                int sum = i * j;
                if (sum <= 9999 && sum >= 1000) {
                    String[] t1 = (sum + "").split("");
                    // 对数组t1进行升序排列
                    Arrays.sort(t1);
                    // 这个地方，把i和j都当String型的字符串加起来组成一个四位数
                    String[] t2 = ("" + i + j).split("");
                    // 对t2进行升序排列
                    Arrays.sort(t2);
                    //下面判断是通过两个已经排好序的数组相比较，当完全相同时执行
                    if (Arrays.equals(t1, t2)) {
                        System.out.println(i + "*" + j + "=" + i * j);
                    }
                }
            }
        }


    }
}
