package com.sulai.aop.supports;

import com.sulai.aop.annotation.PushTask;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * @author:sulai
 * @date:2020/11/1 10:39
 * @description: 这个是启动的时候回初始化bean,和写在构造参数里面效果是一样的;通过接口调用
 * ,用初始化构造器方式,或者用autowire+实现ApplicationContextAware这种方式,
 * 最后通过反射去找到对应的方法,调用invoke方法去执行
 * @version:1.0.0
 */
@Slf4j
@Component
public class ScanAnnotationTest implements ApplicationContextAware {

    @SneakyThrows
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        //貌似只能找类上面的注解
        Map<String, Object> beansWithAnnotation = applicationContext.getBeansWithAnnotation(PushTask.class);
        for (Object obj : beansWithAnnotation.values()) {
            if (obj instanceof PushTask) {
                log.info("击中push task 注解   在service层中....");
            }else{
                log.info("未击中push task 注解   在service层中....");
            }
        }

        // applicationContext 是spring 启动的时候,会扫描所有的注解,会执行
        String[] beanNamesForAnnotation = applicationContext.getBeanNamesForAnnotation(Service.class);
        for (String bean : beanNamesForAnnotation) {
            //Method annotation = applicationContext.getBean(bean).getClass().getMethod("testPushTashAnnotation");
            Method[] methods = applicationContext.getBean(bean).getClass().getMethods();
            for (Method method : methods) {
                PushTask annotation = method.getAnnotation(PushTask.class);
                if (annotation != null) {
                    log.info("击中push task注解上面的方法==={}",method);
                }else{
                    log.info("未击中push task上面的方法==={}",method);
                }
            }



        }
    }
}
