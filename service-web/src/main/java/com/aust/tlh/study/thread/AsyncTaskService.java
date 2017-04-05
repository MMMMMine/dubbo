package com.aust.tlh.study.thread;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * Created by FrankTang on 2017/4/5.
 * Version 1.0
 */
@Service
public class AsyncTaskService {

    @Async
    public void executeAsyncTask(Integer i){
        System.out.println("执行异步任务:" + i );
    }

    @Async
    public void executeAsyncTaskPlus(Integer i){

        System.out.println("执行异步任务+1:" + (i+1));
    }
}
