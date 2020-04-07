package com.mly.mango.admin.properties;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author wyn
 * @Description
 * @date 2020-04-04 16:49
 */
@Data
@ToString
@ConfigurationProperties(prefix = "spring.datasource.druid")
public class DruidDataSourceProperties {
    private String driverClassName;
    private String url;
    private String username;
    private String password;
    private int initialSize;
    private int minIdle;
    private int maxActive=100;
    private long maxWait;
    private long timeBetweenEvictionRunsMillis;

    private long minEvictableIdleTimeMillis;

    private String validationQuery;
    private boolean testWhileIdle;
    private boolean testOnBorrow;
    private boolean testOnReturn;
    private boolean poolPerparedStatements;

    private int maxOpenPreparedStatements;
    private int  maxPoolPreparedStatementPerConnectionSize;

    private String filters;
}
