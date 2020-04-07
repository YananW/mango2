package com.mly.mango.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author wyn
 * @Description
 * @date 2020-04-07 14:48
 */
@RestController
public class CallHelloController {

    //负载均衡器
    //RibbonLoadBalancerClient是Ribbon默认使用的负载均衡器，采用的负载均衡策略是轮询
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @RequestMapping("/call")
    public String call(){

        //1.查找服务，通过LoadBalancer查询服务
        ServiceInstance serviceInstance = loadBalancerClient.choose("mango-producer");

        System.out.println("服务地址："+serviceInstance.getUri());
        System.out.println("服务名称："+serviceInstance.getServiceId());

        //调用服务，通过RestTemplate远程调用服务
        String callServiceResult = new RestTemplate().getForObject(serviceInstance.getUri().toString()+"/hello"
,String.class);
        System.out.println(callServiceResult);
        return callServiceResult;


    }

}
