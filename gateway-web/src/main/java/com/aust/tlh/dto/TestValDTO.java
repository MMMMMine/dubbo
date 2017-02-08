package com.aust.tlh.dto;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * 类描述:
 * Created by tanglinhui on 2017/1/13.
 * Version 1.0
 */
public class TestValDTO implements Serializable{

    @NotEmpty(message = "手机号不能为空!")
    @Pattern(regexp = "(\\+\\d+)?1[3458]\\d{9}$" ,message = "手机号不合法!")
    private String phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
