package com.mly.mango.monitor;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author wyn
 * @Description 项目启动类
 * @date 2020-04-06 20:13
 */
@SpringBootApplication
@EnableAdminServer //开启监控服务
@EnableDiscoveryClient
public class MangoMonitorApplication {

    public static void main(String[] args) {
        SpringApplication.run(MangoMonitorApplication.class,args);
    }
}
