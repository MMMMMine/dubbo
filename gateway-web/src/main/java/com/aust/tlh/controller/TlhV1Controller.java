package com.aust.tlh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 类描述:
 * Created by tanglinhui on 2016/12/21.
 * Version 1.0
 */
@Controller
@RequestMapping("/aust/tlh")
public class TlhV1Controller {

    @RequestMapping(value = "/test" ,produces = "application/json")
    Object tes(@RequestBody String requestData) {
        String json = "{'text':'welcome'}";
        return json;
    }

}
