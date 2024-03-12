package com.winds.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/interceptor")
public class UserController {
    /**
     * 因为配置了拦截器，所以/test请求会被拦截，拦截之后转而执行拦截器方法，
     * test()方法是否执行取决于拦截器是否允许请求通过
     */
    @RequestMapping("/test")
    public String test(){
        return "hello";
    }
}
