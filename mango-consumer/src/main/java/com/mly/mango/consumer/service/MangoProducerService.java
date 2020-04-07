package com.mly.mango.consumer.service;

import com.mly.mango.consumer.controller.MangoProducerHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wyn
 * @Description
 * @date 2020-04-07 15:26
 */
@FeignClient(name = "mango-producer" ,fallback = MangoProducerHystrix.class)
public interface MangoProducerService {

    @RequestMapping("/hello")
    public String hello();
}
