package com.mly.mango.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * @author wyn
 * @Description Hystrix-dashboard是一款针对Hystrix进行实时监控的工具，
 * 通过Hystrix Dashboard我们可以直观地看到各Hystrix Command的请求响应时间、
 * 请求成功率等数据。
 * @date 2020-04-07 17:33
 */
@EnableTurbine //开启Turbine支持
@EnableHystrixDashboard //开启熔断监控支持
@EnableDiscoveryClient //开启服务注册
@SpringBootApplication
public class MangoHystrixApplication {

    public static void main(String[] args) {

        SpringApplication.run(MangoHystrixApplication.class,args);
    }
}
