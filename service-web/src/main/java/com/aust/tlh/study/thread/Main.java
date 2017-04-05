package com.aust.tlh.study.thread;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by FrankTang on 2017/4/5.
 * Version 1.0
 */
public class Main {

    public static void main(String[] args){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TaskExecutorConfig.class);

        AsyncTaskService asyncTaskService = context.getBean(AsyncTaskService.class);

        for (int i = 0; i< 10; i++){
            asyncTaskService.executeAsyncTask(i);
            asyncTaskService.executeAsyncTaskPlus(i);
        }

    }
}
