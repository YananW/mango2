package com.mly.mango.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author wyn
 * @Description
 * @date 2020-04-07 14:55
 */
@RestController
public class RibbonHelloController {


    @Autowired
    private RestTemplate restTemplate;


    @RequestMapping("/ribbon/call")
    public String call() {

        //调用服务。service-producer
        //LoadBalancerInterceptor会拦截并根据服务找到对应的服务
        String callServiceResult = restTemplate.getForObject("http://mango-producer/hello",String.class);
        return callServiceResult;


    }
}
