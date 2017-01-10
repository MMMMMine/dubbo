package com.aust.tlh.study.aspectJ;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 类描述:
 * Created by tanglinhui on 2017/1/10.
 * Version 1.0
 */
@Aspect
@Component
public class Audience {

    @Pointcut("execution(** com.aust.tlh.study.aspectJ.Performance.perform(..))")
    public void performance(){}

    @Before("performance()")
    public void silenceCellPhone(){

        System.out.println("Please silence cell phones");

    }

    @Before("performance()")
    public void takeSeats(){

        System.out.println("Please taking seats");

    }

    @AfterReturning("performance()")
    public void applause(){

        System.out.println("Clap!!Clap!!Clap!!");

    }

    @AfterThrowing("performance()")
    public void demandRefund(){

        System.out.println("Demanding a refund!");

    }

}
