package com.winds;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * 想要使用Servlet三大组件的注解，就必须先在Spring Boot主配置类(即标注了@SpringBootApplication注解的类)上
 * 添加@ServletComponentScan注解，以实现对Servlet，Filter及Listener的扫描
 */
@ServletComponentScan
@SpringBootApplication
public class App {
    public static void main( String[] args ) {
        SpringApplication.run(App.class,args);
    }
}
