package com.aust.tlh.study;

import org.springframework.stereotype.Component;


/**
 * 类描述:@Named @component在很多情况下可以替代，@Named是javax.inject包里的
 * Created by tanglinhui on 2017/1/3.
 * Version 1.0
 */
@Component("peppers")
public class SgtPeppers implements CompactDisc {

    private String title = "Sgt.Pepper's Lonely Hearts Club Band";
    private String artist = "The Frank";

    @Override
    public void play() {
        System.out.println("Playing" + title + "by" + artist);
    }
}
