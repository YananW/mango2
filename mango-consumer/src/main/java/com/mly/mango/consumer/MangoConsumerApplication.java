package com.mly.mango.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author wyn
 * @Description 消费者
 * @date 2020-04-07 14:40
 */
@EnableFeignClients //开启扫描Spring Cloud Feign客户端的功能
@EnableDiscoveryClient
@SpringBootApplication
public class MangoConsumerApplication {

    public static void main(String[] args) {

        SpringApplication.run(MangoConsumerApplication.class,args);

    }

    @Bean
    @LoadBalanced //用于拦截请求
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
