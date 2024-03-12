package com.winds.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 通过实现HandlerExceptionResolver接口处理异常
 */
@Configuration
public class HandlerExceptionResolverImpl implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView modelAndView = new ModelAndView();

        // 判断不同的异常类型，实现不同视图跳转
        if(ex instanceof ArithmeticException){
            modelAndView.addObject("handler","HandlerExceptionResolverImpl#resolveException");
            modelAndView.addObject("msg","除零错误");
            modelAndView.setViewName("error");
        } else if (ex instanceof NullPointerException){
            modelAndView.addObject("handler","HandlerExceptionResolverImpl#resolveException");
            modelAndView.addObject("msg","空指针异常");
            modelAndView.setViewName("error");
        }
        return modelAndView;
    }
}
