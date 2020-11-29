package com.sulai.aop.interceptor;

import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @author:sulai
 * @date:2020/10/31 22:22
 * @description: 载入拦截器
 * @version:1.0.0
 */
@Configuration
public class InterceptorConfiguration implements WebMvcConfigurer {

    @Resource
    PushTaskInterceptor pushTaskInterceptor;

   @Override
   public void addInterceptors(InterceptorRegistry registry) {
       registry.addInterceptor(pushTaskInterceptor)
               .addPathPatterns("/**");
    }
}
