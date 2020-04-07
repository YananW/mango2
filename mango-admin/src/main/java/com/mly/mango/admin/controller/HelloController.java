package com.mly.mango.admin.controller;

import com.mly.mango.admin.properties.DruidDataSourceProperties;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wyn
 * @Description hello测试类
 * @date 2020-03-31 22:11
 */
@RestController
@Api(tags = "测试接口")
public class HelloController {



    @GetMapping("/hello")
    @ApiOperation(value = "测试方法")
    public String hello(){



        return "hello";
    }
}
