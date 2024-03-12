package com.winds.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 因为要使用Thymeleaf进行模板渲染，因此这里直接使用@Controller注解，避免将返回值转换为json字符串
 */
@Controller
@RequestMapping("/exception")
public class ExceptionController {
    @RequestMapping("/arithmetic")
    public String exceptionMethod(Model model) throws Exception{
        model.addAttribute("msg","没有抛出异常");
        /* 抛出异常: java.lang.ArithmeticException */
        int num = 1/0;

        return "index";   //返回index.html页面
    }

    @RequestMapping("/nullpointer")
    public String exceptionMethod1(Model model){
        model.addAttribute("msg","没有抛出异常");
        String str = null;
        /* 抛出异常: java.lang.NullPointerException */
        str.getBytes();

        return "index";
    }
}
