package com.mly.mango.consumer.controller;

import com.mly.mango.consumer.service.MangoProducerService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wyn
 * @Description 回调类
 * @date 2020-04-07 17:21
 */
@Component
public class MangoProducerHystrix implements MangoProducerService {


    @RequestMapping("/hello")
    @Override
    public String hello() {
        return "sorry,hello service call failed";
    }
}
