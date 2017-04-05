package com.aust.tlh.study.schedule;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by FrankTang on 2017/4/5.
 * Version 1.0
 */
public class Main {

    public static void main(String[] args){

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(TaskScheduleConfig.class);

    }
}
