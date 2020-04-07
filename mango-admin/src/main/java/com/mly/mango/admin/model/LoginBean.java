package com.mly.mango.admin.model;

import lombok.Data;
import lombok.ToString;

/**
 * @author wyn
 * @Description 登陆接口封装对象
 * @date 2020-04-06 10:16
 */
@Data
@ToString
public class LoginBean {

    private String account;
    private String password;
    private String captcha;
}
