package com.mly.mango.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author wyn
 * @Description
 * @date 2020-04-07 14:30
 */
@EnableDiscoveryClient
@SpringBootApplication
public class MangoProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MangoProducerApplication.class,args);

    }
}
