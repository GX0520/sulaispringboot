package com.sulai.aop.interceptor;

import com.sulai.aop.annotation.PushTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author:sulai
 * @date:2020/10/31 20:56
 * @description: 配置拦截器后还需要载入
 * @version:1.0.0
 */
@Slf4j
@Configuration
public class PushTaskInterceptor implements HandlerInterceptor {

    /**
     * 这种方式貌似只能拿到controller里面的注解,
     * 拿不到service里面的注解
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        if (handler instanceof HandlerMethod) {
          HandlerMethod handlerMethod=  (HandlerMethod) handler;
            if (handlerMethod.getBeanType().getMethod("doPushTask").isAnnotationPresent(PushTask.class)) {
                log.info("命中push task 注解");
            }else{
                log.info("未命中push task 注解");
            }
            return true;
        }
        return true;
    }
}
