package com.sulai.aop.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @Author:sulai
 * @Date:2020/10/25 15:09
 * @Description: 类注解,目的根据type找到各个bean
 * @Version:1.0.0
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.TYPE)
@Documented
//注解采用自动转配,不然找不到getBeanOfType找不到
@Component
public @interface ChatTypeHand {
    String type();
}
