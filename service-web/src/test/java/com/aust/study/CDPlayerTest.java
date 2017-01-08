package com.aust.study;

import com.aust.tlh.study.baseBean.CDPlayerConfig;
import com.aust.tlh.study.baseBean.CompactDisc;
import com.aust.tlh.study.baseBean.MediaPlayer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
/**
 * 类描述:
 * Created by tanglinhui on 2017/1/3.
 * Version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= CDPlayerConfig.class)
public class CDPlayerTest {

    @Autowired
    private CompactDisc cd ;

    @Autowired
    private MediaPlayer player;

    @Test
    public void cdShouldNotBeNull(){
        cd.play();
    }

    @Test
    public void cdPlayer(){
        player.play();
    }

}
