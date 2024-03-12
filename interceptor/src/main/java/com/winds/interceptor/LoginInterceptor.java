package com.winds.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.lang.reflect.Method;

/**
 * 自定义拦截器
 * 每个拦截器都需要实现HandlerInterceptor接口
 */
public class LoginInterceptor implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 获取Controller中被拦截的方法名
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        String methodName = method.getName();

        // 日志记录拦截到的方法名
        logger.info("====拦截到了方法：{},在该方法执行之前执行preHandle====",methodName);

        // 判断用户有没有登陆成功，一般登陆成功的用户都有一个对应的token
        String token = request.getParameter("token");   // 从url中获取token
        if(null == token || "".equals(token)){
            logger.info("用户未登录，没有权限执行... ...请登录");
            return false;
        }

        // 返回true时才会继续执行，返回false则取消当前请求
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.info("执行完方法之后执行(Controller方法调用之后)，但是此时还没有进行视图渲染");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        logger.info("整个请求都已处理完，DispatcherServlet也渲染了对应的视图，此时可以做一些清理工作");
    }
}
