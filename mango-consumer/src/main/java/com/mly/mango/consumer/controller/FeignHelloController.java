package com.mly.mango.consumer.controller;

import com.mly.mango.consumer.service.MangoProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wyn
 * @Description
 * @date 2020-04-07 15:27
 */
@RestController
public class FeignHelloController {

    @Autowired
    private MangoProducerService mangoProducerService;


    @RequestMapping("/fegin/call")
    public String call(){

        //像调用本地服务一样
        return mangoProducerService.hello();

    }
}


