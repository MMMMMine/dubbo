package com.aust.tlh.study.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by FrankTang on 2017/4/5.
 * Version 1.0
 */
@Service
public class ScheduledTaskService {

    private static final SimpleDateFormat dateFomate = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime(){
        System.out.println("每隔5秒执行一次"+ dateFomate.format(new Date()));
    }

    @Scheduled(cron = "0 17 17 ? * * ")
    public void fixTimeExecution(){
        System.out.println("在指定时间" +dateFomate.format(new Date())+"执行");
    }
}
