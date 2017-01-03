package com.aust.tlh.study;

import org.springframework.stereotype.Component;


/**
 * 类描述:
 * Created by tanglinhui on 2017/1/3.
 * Version 1.0
 */
@Component
public class SgtPeppers implements CompactDisc {

    private String title = "Sgt.Pepper's Lonely Hearts Club Band";
    private String artist = "The Frank";

    @Override
    public void play() {
        System.out.println("Playing" + title + "by" + artist);
    }
}
