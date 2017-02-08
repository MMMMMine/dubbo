package com.aust.tlh.controller;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.dubbo.config.annotation.Reference;
import com.aust.tlh.dto.TestValDTO;
import com.aust.tlh.webservice.ITlhTestDubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

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
    public Object dubboInvoke() {

        System.out.println("test");

        return tlhTestDubboService.invokeTest();

    }


    public static void main(String[] args) throws Exception {

        TestValDTO testValDTO = new TestValDTO();
        testValDTO.setPhone("132154321313");
        String a = validatorParamReturn(testValDTO);

        System.out.println(a);

    }

    public static <T> String validatorParamReturn(T object) {
		/* 创建效验工厂 */
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();

		/* 将类型装载效验 */
        Set<ConstraintViolation<T>> set = validator.validate(object);
        StringBuffer sb = new StringBuffer("");
        for (ConstraintViolation<T> constraintViolation : set) {
            sb.append(constraintViolation.getMessage());
        }

        if (!StringUtils.isBlank(sb.toString())) {
            return sb.toString();
        }

        return "";
    }

}



