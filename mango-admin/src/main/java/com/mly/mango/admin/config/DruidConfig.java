package com.mly.mango.admin.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.mly.mango.admin.properties.DruidDataSourceProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.servlet.Servlet;
import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author wyn
 * @Description Druid数据库连接池配置类
 * @date 2020-04-02 15:23
 */
@Configuration
//导入一个druid的配置信息
@EnableConfigurationProperties({DruidDataSourceProperties.class})
public class DruidConfig {

    @Autowired
    private DruidDataSourceProperties properties;


    @Bean
    @ConditionalOnMissingBean
    public DataSource druidDataSource() {

        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(properties.getDriverClassName());
        druidDataSource.setUrl(properties.getUrl());
        druidDataSource.setUsername(properties.getUsername());
        druidDataSource.setPassword(properties.getPassword());
        druidDataSource.setInitialSize(properties.getInitialSize());
        druidDataSource.setMinIdle(properties.getMinIdle());
        druidDataSource.setMaxActive(properties.getMaxActive());
        druidDataSource.setMaxWait(properties.getMaxWait());
        druidDataSource.setTimeBetweenEvictionRunsMillis(properties.getTimeBetweenEvictionRunsMillis());
        druidDataSource.setMinEvictableIdleTimeMillis(properties.getMinEvictableIdleTimeMillis());
        druidDataSource.setValidationQuery(properties.getValidationQuery());
        druidDataSource.setTestWhileIdle(properties.isTestWhileIdle());
        druidDataSource.setTestOnBorrow(properties.isTestOnBorrow());
        druidDataSource.setTestOnReturn(properties.isTestOnReturn());
        druidDataSource.setPoolPreparedStatements(properties.isPoolPerparedStatements());
        druidDataSource.setMaxPoolPreparedStatementPerConnectionSize(properties.getMaxPoolPreparedStatementPerConnectionSize());

        try {
            druidDataSource.setFilters(properties.getFilters());
            druidDataSource.init();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return druidDataSource;
    }


    /**
     * 注册servlet信息，配置监控视图
     * @return
     */
    @Bean
    @ConditionalOnMissingBean
    public ServletRegistrationBean<Servlet> druidServlet() {


        ServletRegistrationBean<Servlet> servletServletRegistrationBean =
                new ServletRegistrationBean<>(new StatViewServlet(),"/druid/*");

        //白名单

        servletServletRegistrationBean.addInitParameter("allow","127.0.0.1,139.196.87.48");

        ///IP黑名单（存在共同时，deny优先于allow）
        //如果满足deny的话提示：Sorry,you are permitted to views this page.
        servletServletRegistrationBean.addInitParameter("deny","192.168.1.119");
        //登录查看信息的账号密码，用于登录Druid监控后台
        servletServletRegistrationBean.addInitParameter("loginUsername","admin");
        servletServletRegistrationBean.addInitParameter("loginPassword","admin");
        //是否能够重置数据
        servletServletRegistrationBean.addInitParameter("resetEnable","true");
        return servletServletRegistrationBean;

    }


    /**
     * 注册filter信息，监控拦截器
     * @return
     */
    @Bean
    @ConditionalOnMissingBean
    public FilterRegistrationBean<Filter> filterFilterRegistrationBean() {

        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<Filter>();
        filterRegistrationBean.setFilter(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }
}
