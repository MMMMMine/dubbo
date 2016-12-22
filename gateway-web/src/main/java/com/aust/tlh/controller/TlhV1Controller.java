package com.aust.tlh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 类描述:
 * Created by tanglinhui on 2016/12/21.
 * Version 1.0
 */
@Controller
@RequestMapping("/aust/tlh")
public class TlhV1Controller {

    @RequestMapping(value = "/test",method = RequestMethod.POST)
    @ResponseBody
    Object test(@RequestBody String req, HttpServletRequest httpServletRequest) {

        return "welcome";
    }

}
