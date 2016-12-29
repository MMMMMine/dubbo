package com.aust.tlh.webservice.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.aust.tlh.webservice.ITlhTestDubboService;
import org.springframework.stereotype.Component;

/**
 * 类描述:
 * Created by tanglinhui on 2016/12/29.
 * Version 1.0
 */
@Service(version = "1.0.0")
@Component
public class TlhTestDubboServiceImpl implements ITlhTestDubboService{

    @Override
    public String invokeTest() {
        return "testSuccess";
    }
}
