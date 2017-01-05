package com.aust.tlh.study;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 类描述:此配置类只能扫描该包及该包以下目录，若bean不在范围内，无法扫描并注入到spring中
 * 如果想设置basePackage，可以通过属性basePackages 对扫描进行设置，如下
 * Created by tanglinhui on 2017/1/3.
 * Version 1.0
 */
@Configuration
//@ComponentScan(basePackages = "com.aust.tlh")//这个属性是可以设置多个值的，{"com.aust.tlh","com.aust.msj"}
//@ComponentScan(basePackageClasses = SgtPeppers.class)//扫描具体class,多个用，隔开
public class CDPlayerConfig {

    @Bean(name = "peppers")
    public CompactDisc sgtPeppers(){
        return new SgtPeppers();
    }

    @Bean
    public CDPlayer CDPlayer(){
        return new CDPlayer(new SgtPeppers());
    }

}
