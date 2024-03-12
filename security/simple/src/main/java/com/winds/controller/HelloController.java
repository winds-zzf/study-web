package com.winds.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 1. 通过了Spring Security的安全认证之后才会访问控制器里的接口，也就是说控制器中的接口是被保护的。
 * 2. Security默认用户名和密码
 *  - 用户名:user
 *  - 密码:Spring Security启动时自动生成默认密码，记录在启动日志中
 */
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String home(){
        return "Hello,spring security";
    }
}
