package com.mly.mango.backup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author wyn
 * @Description 项目启动类
 * @date 2020-04-06 18:16
 */
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {"com.mly.mango"})
public class MangoBackupApplication {

    public static void main(String[] args) {
        SpringApplication.run(MangoBackupApplication.class,args);
    }
}
