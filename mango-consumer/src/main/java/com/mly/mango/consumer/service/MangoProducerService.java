package com.mly.mango.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wyn
 * @Description
 * @date 2020-04-07 15:26
 */
@FeignClient(name = "mango-producer")
public interface MangoProducerService {

    @RequestMapping("/hello")
    public String hello();
}
