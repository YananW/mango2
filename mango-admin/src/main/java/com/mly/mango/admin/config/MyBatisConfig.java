package com.mly.mango.admin.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * @author wyn
 * @Description MyBatis配置类
 * @date 2020-03-31 22:26
 */

@Configuration
@MapperScan("com.mly.mango.admin.mapper")//扫描mapper类
public class MyBatisConfig {

    @Autowired
    private DataSource dataSource;

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {


        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();

//
        sessionFactoryBean.setDataSource(dataSource);
        //设置扫描model的路径
        sessionFactoryBean.setTypeAliasesPackage("com.mly.mango.admin.model");

        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

        //设置扫描映射文件的路径 在resource/mapper/*.xml
        sessionFactoryBean.setMapperLocations(resolver.getResources("classpath*:**/*Mapper.xml"));


        return sessionFactoryBean.getObject();

    }


}
