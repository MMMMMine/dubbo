package com.aust.tlh;

import com.aust.tlh.webservice.ITlhTestDubboService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 类描述:
 * Created by tanglinhui on 2016/12/29.
 * Version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:core/dubbo-consumer.xml"})
public class DubboTest {

    @Autowired
    ITlhTestDubboService tlhTestDubboService;

    @Test
    public void testDubbo(){

        String test = tlhTestDubboService.invokeTest();

        System.out.println(test);

    }

}
