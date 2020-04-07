package com.mly.mango.zuul.provider;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author wyn
 * @Description 自定义熔断器  实现熔断器功能
 * @date 2020-04-07 19:13
 */
@Component
public class MyFallbackProvider implements FallbackProvider {


    /**
     * 用于指定熔断器功能应用于哪些路由的服务
     * @return
     */
    @Override
    public String getRoute() {
        return "mango-consumer";
    }

    /**
     * 为进入熔断器功能时执行的逻辑
     * @param route
     * @param cause
     * @return
     */
    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        System.out.println("route:"+route);
        System.out.println("exception:"+cause.getMessage());

        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return 200;
            }

            @Override
            public String getStatusText() throws IOException {
                return "ok";
            }

            @Override
            public void close() {

            }

            @Override
            public InputStream getBody() throws IOException {
                return new ByteArrayInputStream("Sorry, the service is unavailable now.".getBytes());
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders httpHeaders = new HttpHeaders();
                httpHeaders.setContentType(MediaType.APPLICATION_JSON);
                return httpHeaders;
            }
        };
    }
}
