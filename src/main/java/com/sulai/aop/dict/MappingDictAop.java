package com.sulai.aop.dict;

import com.sulai.response.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;

/**
 * @author :sulai
 * @version :1.0.0
 * @date :2021/1/8 23:39
 * @description: description
 */
@Component
@Aspect
@Slf4j
public class MappingDictAop {

    /**
     * 匹配dict包下所有方法,包含子包下的方法
     */
    @Pointcut("execution(* com.sulai.aop.router.*.*(..))")
    public void mappingDict() {
    }

    @Around("mappingDict()")
    public <T> T mapping(ProceedingJoinPoint joinPoint) throws Throwable {
        //获取参数
        Object[] args = joinPoint.getArgs();
        System.out.println("参数:agrs=" + args);
        //获取返回值
        Object proceed = joinPoint.proceed();
        if (proceed instanceof CommonResult && proceed != null) {
            CommonResult proceed1 = (CommonResult) proceed;
            Object data = proceed1.getData();
            if (data != null) {
                Class<?> targetClass = data.getClass();
                toMappingDict(targetClass, data);
            }

        } else {
            log.info("not instance if CommResult,con't mapping basedict.");
        }
        System.out.println("mapping返回值=" + proceed);
        return (T) proceed;

    }


    private void toMappingDict(Class<?> targetClass, Object data) throws IllegalAccessException {
        if (targetClass.isAnnotationPresent(DictCheck.class)) {
            Field[] fields = targetClass.getDeclaredFields();
            Field.setAccessible(fields, true);

            for (Field field : fields) {

                if (field.isAnnotationPresent(DictCheck.class)) {
                    toMappingDict(field.getType(), field.get(data));
                }

                if (field.isAnnotationPresent(DictMapping.class)) {
                    DictMapping annotation = field.getAnnotation(DictMapping.class);
                    String keyName = annotation.keyName();
                    String dictName = annotation.dictName();

                    //默认是value+Id,字典表组合,可以写个枚举
                    if (StringUtils.isEmpty(keyName)) {
                        keyName = field.getName() + "Id";
                    }
                    if (StringUtils.isEmpty(dictName)) {
                        dictName = field.getName();
                    }

                    try {

                        //获取字典表对应的code 字段
                        Field mappingField = targetClass.getDeclaredField(keyName);
                        Field targetField = targetClass.getDeclaredField(dictName);

                        if (getFieldValue(targetField, data) == null) {
                            Object dictValue = getFieldValue(mappingField, data);

                            if (dictValue != null) {
                                int dictCode = Integer.parseInt(dictValue.toString());
                                String dictName1 = DictEnumValue.getDictName(dictCode);

                                //set object value
                                targetField.set(data, dictName1);
                            }
                        }
                    } catch (IllegalArgumentException | NoSuchFieldException | IllegalAccessException e) {
                        log.debug("get filed value error ", e.getMessage());
                    }
                }
            }
        }
    }


    private Object getFieldValue(Field field, Object object) {
        field.setAccessible(true);
        try {
            Object value = field.get(object);
            return value;
        } catch (IllegalAccessException e) {
            log.debug("get field value error {}", e.getMessage());
        }
        return null;
    }

}
