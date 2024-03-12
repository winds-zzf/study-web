package com.winds.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 因为要使用Thymeleaf进行模板渲染，因此这里直接使用@Controller注解，避免将返回值转换为json字符串
 */
@Controller
public class ExceptionController {
    private static final Logger log = LoggerFactory.getLogger(ExceptionController.class);

    @RequestMapping("/exceptionMethod")
    public String exceptionMethod(Model model) throws Exception{
        model.addAttribute("msg","没有抛出异常");
        /* 抛出异常: java.lang.ArithmeticException: /by zero */
        int num = 1/0;
        /**
         * 抛出异常后，程序转到异常处理机制。
         * SpringBoot默认的异常处理机制是当程序中出现了异常，SpringBoot就会请求/error的URL
         * 在SpringBoot中默认由BasicExceptionController类来处理/error请求，然后向用户发送默认异常处理页面来展示异常信息
         * 这是如果在class:/templates/有error.html，则会优先使用该异常处理页面
         */
        log.info(String.valueOf(num));
        return "index";   //返回index.html页面
    }
}
