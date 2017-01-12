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

    private static final int DEFAULT_MAX_RETRIES = 2;

    private int maxRetries = DEFAULT_MAX_RETRIES;

    @Pointcut("execution(** com.aust.tlh.study.aspectJ.Performance.perform2(..))")
    public void performance() {
    }

    //失败继续尝试，并设定最大尝试次数，环绕通知的
    @Around(value = "performance()")
    public void watchPerformance(ProceedingJoinPoint jp) throws Throwable {

        int numAttempts = 0;
        Exception lockFailureException = null;

        try {
            do {
                numAttempts++;
                try {

                    System.out.println("Please silence cell phones");
                    System.out.println("Please taking seats");

                    jp.proceed();

                    System.out.println("Clap!!Clap!!Clap!!");

                } catch (Exception e) {

                    lockFailureException = e;

                }
            } while (numAttempts <= maxRetries);

            throw lockFailureException;

        }catch (Throwable e){

            System.out.println("Demanding a refund");

        }


    }
}
