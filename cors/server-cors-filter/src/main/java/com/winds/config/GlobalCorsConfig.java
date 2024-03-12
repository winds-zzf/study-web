package com.winds.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class GlobalCorsConfig {
    /**
     * 注意使用的CorsFilter是org.springframework.web.filter.CorsFilter
     */
    @Bean
    public CorsFilter corsFilter(){
        // 1. 添加cors配置信息
        CorsConfiguration config = new CorsConfiguration();
        // 1) 允许接受的域，不要写*，否则cookie就无法使用了
        config.addAllowedOrigin("http://localhost:8080");
        // 2) 是否发送Cookie信息
        config.setAllowCredentials(true);
        // 3) 允许的请求方式
        config.addAllowedMethod("OPTIONS");
        config.addAllowedMethod("HEAD");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("DELETE");
        config.addAllowedMethod("PATCH");
        // 4) 允许的头信息
        config.addAllowedHeader("*");
        // 2. 添加映射路径，我们拦截一切请求
        UrlBasedCorsConfigurationSource configSource = new UrlBasedCorsConfigurationSource();
        configSource.registerCorsConfiguration("/**",config);

        // 返回新的CorsFilter
        return new CorsFilter(configSource);
    }
}
