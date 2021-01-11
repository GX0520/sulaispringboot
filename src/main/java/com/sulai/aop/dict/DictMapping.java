package com.sulai.aop.dict;

import java.lang.annotation.*;

/**
 * @author :sulai
 * @version :1.0.0
 * @date :2021/1/8 23:32
 * @description: 映射vo 的basedict注解
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface DictMapping {

    /**
     * 字典表的对应映射的字段
     * @return
     */
     String keyName() default "";

    /**
     * 字典表 code 字段
     * @return
     */
    String dictName() default "";

}
