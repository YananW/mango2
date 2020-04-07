package com.mly.mango.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author wyn
 * @Description SpringBoot启动类
 * @date 2020-04-04 16:27
 */
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {"com.mly.mango.admin"})
public class MyApplication {


    public static void main(String[] args) {

        SpringApplication.run(MyApplication.class,args);
    }
}
