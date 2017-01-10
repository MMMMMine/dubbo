package com.aust.tlh.study.baseBean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


/**
 * 类描述:@Named @component在很多情况下可以替代，@Named是javax.inject包里的
 * Created by tanglinhui on 2017/1/3.
 * Version 1.0
 */
@Component()
public class SgtPeppers implements CompactDisc {

    @Value("#{T(System).currentTimeMillis()}")
    private String time;

    @Value("#{sgtPeppers.artist}")  //"#{bean.field}必须是public，privite无法访问"
    private String title ;//= "Sgt.Pepper's Lonely Hearts Club Band";
    @Value("${artist}")
    public String artist;// = "The Frank";

//    public SgtPeppers(String title, String artist) {
//        this.title = title;
//        this.artist = artist;
//    }

    public SgtPeppers() {
    }

    @Override
    public void play() {
        System.out.println(time);
        System.out.println("Playing" + title + "by" + artist);
    }
}
