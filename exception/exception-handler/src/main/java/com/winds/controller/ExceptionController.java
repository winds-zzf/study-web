package com.winds.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
        log.info(String.valueOf(num));
        return "index";   //返回index.html页面
    }

    /**
     * description: 捕获ExceptionController(当前Controller类)中的ArithmeticException(由注解的value属性指定)
     * @param model 将model对象注入方法中
     * @param e 将产生异常对象注入到方法
     * @return 指定错误页面
     */
    @ExceptionHandler(value={ArithmeticException.class})    // value指定需要拦截的异常类型
    public String arithmeticExceptionHandle(Model model,Exception e){
        model.addAttribute("msg","使用@ExceptionHandler注解处理异常\n"+e.getMessage());
        log.info(e.getMessage());
        return "error";    // 返回classpath:/templates/error.html
    }
}
