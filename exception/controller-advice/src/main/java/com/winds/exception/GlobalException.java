package com.winds.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 定义一个GlobalException来处理全局异常，它需要使用@ControllerAdvice进行注解
 */
@ControllerAdvice
public class GlobalException {
    // record log
    private static final Logger log = LoggerFactory.getLogger(GlobalException.class);

    /**
     * Description: 捕获ArithmeticException，进行异常处理并返回异常信息页面error
     * @param model 将Model对象注入方法中
     * @param e 将产生的异常对象注入到方法中
     * @return 指定错误页面
     */
    @ExceptionHandler(value = {ArithmeticException.class})  // 处理ArithmeticException异常
    public String arithmeticExceptionHandle(Model model,Exception e){
        model.addAttribute("handler:"+"GlobalException#nullPointerExceptionHandle");
        model.addAttribute("msg","算术异常\n"+e.getMessage());
        log.info(e.getMessage());
        return "error"; // 异常处理函数返回的应该是error相关的页面
    }

    /**
     * Description: 捕获NullPointerException，进行异常处理并返回异常信息页面error
     */
    @ExceptionHandler(value = {NullPointerException.class})
    public String nullPointerExceptionHandle(Model model,Exception e){
        model.addAttribute("handler:"+"GlobalException#nullPointerExceptionHandle");
        model.addAttribute("msg","空指针异常\n"+e.getMessage());
        return "error"; // 也可以返回其他的异常处理页面
    }

    /*
     * 其他具体的异常处理方法
     */

    /**
     * 系统异常，预期以外的异常
     * 在项目中，可以把拦截Exception异常写在GlobalException最下面，如果还是没有找到常见异常，最后再拦截以下Exception异常，保证异常得到处理
     */
    @ExceptionHandler(value = {Exception.class})
    public String exceptionHandle(Model model,Exception e){
        model.addAttribute("handler","GlobalException#exceptionHandle");
        model.addAttribute("msg","通用异常处理\n"+e.getMessage());
        return "error";
    }
}
