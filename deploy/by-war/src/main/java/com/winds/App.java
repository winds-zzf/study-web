package com.winds;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * 启动类继承SpringBootServletInitializer并重写config方法
 */
@SpringBootApplication
public class App extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        /* 注意这里要指向原先用main方法执行的App启动类 */
        return builder.sources(App.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }
}
