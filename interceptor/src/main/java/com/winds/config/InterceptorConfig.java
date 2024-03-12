package com.winds.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.winds.interceptor.LoginInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 需要拦截的路径，/**表示需要拦截所有请求
        String[] addPathPatterns={"/**"};
        // 不需要拦截的路径，表示除了登陆与注册之外，因为注册不需要登陆也可以访问
        String[] excludePathPatterns={
            "/login.html",
            "/registry.html"
        };

        // 注册一个拦截器
        registry.addInterceptor(new LoginInterceptor())     //要注册的自定义拦截器
                .addPathPatterns(addPathPatterns)           //告诉拦截器需要拦截的路径
                .excludePathPatterns(excludePathPatterns);  //告诉拦截器不需要拦截的路径
        /*
        // 注册一个权限拦截器，如果有多个拦截器，只需添加以下一行代码
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns(addPathPatterns)
                .excludePathPatterns(excludePathPatterns);
         */
    }
}
