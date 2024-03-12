package com.winds;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 使用@MapperScan注解Mapper接口路径
 * 1. @MapperScan("org.winds.mapper")   直接在括号中写入Mapper接口包路径字符串
 * 2. @MapperScan("org.winds,mapper1","org.winds.mapper1") 将多个Mapper接口包路径字符串使用逗号分隔
 */
@SpringBootApplication
public class App {
    public static void main( String[] args ) {
        SpringApplication.run(App.class,args);
    }
}
