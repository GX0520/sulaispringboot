package com.sulai.aop.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author:sulai
 * @Date:2020/10/25 16:48
 * @Description: 推送任务,方法的注解
 * @Version:1.0.0
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.METHOD)
public @interface PushTask {
     String value() default "";
}
