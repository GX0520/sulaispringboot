package com.sulai.aop.dict;

import java.lang.annotation.*;

/**
 * @author :sulai
 * @version :1.0.0
 * @date :2021/1/9 0:31
 * @description: description
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.FIELD})
public @interface DictCheck {
}
