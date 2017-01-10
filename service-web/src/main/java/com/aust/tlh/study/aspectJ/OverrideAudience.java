package com.aust.tlh.study.aspectJ;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 类描述:
 * Created by tanglinhui on 2017/1/10.
 * Version 1.0
 */
@Aspect
@Component
public class OverrideAudience {

    @Pointcut("execution(** com.aust.tlh.study.aspectJ.Performance.perform2(..))")
    public void performance(){}

    @Around(value = "performance()")
    public void watchPerformance(ProceedingJoinPoint jp){

        try {

            System.out.println("Please silence cell phones");
            System.out.println("Please taking seats");

            jp.proceed();

            System.out.println("Clap!!Clap!!Clap!!");

        }catch (Throwable e){

            System.out.println("Demanding a refund!");

        }
    }
}
