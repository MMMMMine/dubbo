package com.aust.tlh.study.aspectJ;

import org.springframework.stereotype.Service;

/**
 * 类描述:
 * Created by tanglinhui on 2017/1/10.
 * Version 1.0
 */
@Service
public class Concert implements Performance {

    @Override
    public void performance() {

        System.out.println("perform success ! ");

    }

    @Override
    public void perform2() throws Exception{

        //System.out.println("doBusiness");

        throw new Exception("我失败了");



    }
}
