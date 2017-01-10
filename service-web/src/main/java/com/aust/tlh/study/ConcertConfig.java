package com.aust.tlh.study;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 类描述:
 * Created by tanglinhui on 2017/1/10.
 * Version 1.0
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "com.aust.tlh.study")
public class ConcertConfig {

}
