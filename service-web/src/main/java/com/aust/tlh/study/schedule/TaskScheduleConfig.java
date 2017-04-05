package com.aust.tlh.study.schedule;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by FrankTang on 2017/4/5.
 * Version 1.0
 */
@Configuration
@ComponentScan("com.aust.tlh.study.schedule")
@EnableScheduling
public class TaskScheduleConfig {
}
