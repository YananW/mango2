package com.mly.mango.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author wyn
 * @Description
 * @date 2020-04-07 14:40
 */
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
