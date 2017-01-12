package com.aust.tlh.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.aust.tlh.webservice.ITlhTestDubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 类描述:
 * Created by tanglinhui on 2017/1/12.
 * Version 1.0
 */
@Controller
@RequestMapping("/aust/tlh")
public class TlhV2Controller {

    @Autowired
    private ITlhTestDubboService tlhTestDubboService;

    @RequestMapping(value = "/dubboInvoke", method = RequestMethod.POST)
    @ResponseBody
    Object dubboInvoke(@RequestBody String request) {

        return tlhTestDubboService.invokeTest();

    }


}
