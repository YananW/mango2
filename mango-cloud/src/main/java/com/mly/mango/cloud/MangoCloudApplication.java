package com.mly.mango.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author wyn
 * @Description
 * @date 2020-04-07 10:07
 */
@EnableEurekaServer //标识这是一个Eureka服务
@SpringBootApplication
public class MangoCloudApplication {
    public static void main(String[] args) {
        SpringApplication.run(MangoCloudApplication.class,args);
    }
}
