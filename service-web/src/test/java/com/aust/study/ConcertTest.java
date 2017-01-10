package com.aust.study;

import com.aust.tlh.study.aspectJ.Audience;
import com.aust.tlh.study.ConcertConfig;
import com.aust.tlh.study.aspectJ.Perfermance;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 类描述:
 * Created by tanglinhui on 2017/1/10.
 * Version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= ConcertConfig.class)
public class ConcertTest {

    @Autowired
    private Perfermance perfermance;

    @Test
    public void testConcert(){
        perfermance.perform();
    }
}
