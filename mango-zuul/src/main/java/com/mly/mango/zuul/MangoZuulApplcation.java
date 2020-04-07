package com.mly.mango.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author wyn
 * @Description
 * @date 2020-04-07 18:49
 */
@EnableZuulProxy //开启服务网关支持
@SpringBootApplication
public class MangoZuulApplcation {
    public static void main(String[] args) {
        SpringApplication.run(MangoZuulApplcation.class,args);

    }
}
