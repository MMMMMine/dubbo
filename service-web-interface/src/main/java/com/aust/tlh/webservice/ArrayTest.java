package com.aust.tlh.webservice;

import com.aust.tlh.dto.OrdArray;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 类描述:
 * Created by tanglinhui on 2017/2/6.
 * Version 1.0
 */
public class ArrayTest {
    public static void main(String[] args) {
        int maxSize = 100;
        OrdArray arr;
        arr = new OrdArray(maxSize);
        arr.insert(77);
        arr.insert(88);
        arr.insert(99);
        arr.insert(11);
        arr.insert(33);
        arr.insert(22);
        arr.insert(44);
        arr.insert(55);
        arr.insert(66);
        arr.insert(00);
        int searchKey = 12;
        System.out.println("arraySize = "+arr.size());
        if (arr.find(searchKey) != arr.size()){
            System.out.println("Found " +searchKey);
        }
        else{
            System.out.println("Can't find "+searchKey);
        }
        arr.display();

        arr.delete(00);
        arr.delete(22);
        arr.delete(33);

        arr.display();


        List<Integer> array = new ArrayList<>();
        array.add(77);
        array.add(88);
        array.add(99);
        array.add(11);
        array.add(33);
        array.add(22);
        array.add(44);
        array.add(55);
        array.add(66);
        array.add(00);
        System.out.println(array.contains(22));
    }


    Random rand = new Random(47);


}
