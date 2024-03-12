package com.winds.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.Properties;

/**
 * 通过将SimpleMappingExceptionResolver类注入Spring容器处理异常
 */
@Configuration
public class GlobalException {
    @Bean
    public SimpleMappingExceptionResolver getSimpleMappingExceptionResolver(){
        SimpleMappingExceptionResolver resolver = new SimpleMappingExceptionResolver();
        Properties mappings = new Properties();
        /*
         * 参数一: 异常的类型，注意必须是异常类型的全名
         * 参数二: 视图名称，error.html
         * 可以设置多个"异常类型-处理页面"的映射关系
         */
        mappings.put("java.lang.ArithmeticException","error");
        mappings.put("java.lang.NullPointerException","error");
        // 设置异常与视图映射信息
        resolver.setExceptionMappings(mappings);
        return resolver;
    }
}
