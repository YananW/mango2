package com.mly.mango.consumer;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
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
@EnableDiscoveryClient //开启服务注册
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

    //此配置是为了服务监控而配置，与服务容错本身无关
    //ServletRegistrationBean 因为Springboot的默认路径不是"/hystrix.stream"
    //只要在自己的项目里配置上下面的servlet就可以了
    @Bean
    public ServletRegistrationBean getServlet() {

        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();

        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);

        registrationBean.setLoadOnStartup(1);

        registrationBean.addUrlMappings("/hystrix.stream");

        registrationBean.setName("HystrixMetricsStreamServlet");

        return registrationBean;
    }
}
