package com.mly.mango.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wyn
 * @Description
 * @date 2020-04-07 14:41
 */
@RestController
public class ServiceController {


    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private DiscoveryClient discoveryClient;


    /**
     * 获取所有服务
     * @return
     */
    @RequestMapping("/services")
    public Object services() {

        return discoveryClient.getInstances("mango-producer");


    }

    @RequestMapping("/discover")
    public  Object discover(){

        return loadBalancerClient.choose("mango-producer").getUri().toString();

    }
}
