package com.aust.tlh.study.baseBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 类描述:
 * Created by tanglinhui on 2017/1/4.
 * Version 1.0
 */
@Component
public class CDPlayer implements MediaPlayer {

    private CompactDisc cd;

    @Autowired //@autowire 和 @inject 在大部分情况下可以互相替代
    public CDPlayer(CompactDisc cd) {
        this.cd = cd;
    }

    @Override
    public void play() {

        cd.play();

    }


}
