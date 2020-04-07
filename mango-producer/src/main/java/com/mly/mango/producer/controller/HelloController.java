package com.mly.mango.producer.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wyn
 * @Description 测试控制器
 * @date 2020-04-07 14:31
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
     public String hello(){

        return "hello mango!";
     }
}
