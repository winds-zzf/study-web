package com.winds.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    /* 把配置文件中的spring.datasource.druid.xxx等属性和DruidDataSource中的属性进行绑定 */
    @ConfigurationProperties(prefix="spring.datasource.druid")
    @Bean
    public DruidDataSource druidDataSource(){
        return new DruidDataSource();
    }
}
