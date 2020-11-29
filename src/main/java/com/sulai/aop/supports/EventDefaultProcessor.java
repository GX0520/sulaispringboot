package com.sulai.aop.supports;

import com.sulai.aop.model.TaskModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @Author:sulai
 * @Date:2020/10/25 22:18
 * @Description:
 * @Version:1.0.0
 */
@Slf4j
public class EventDefaultProcessor implements SendRequestProcessor, ApplicationContextAware {

    private EventDispatch eventDispatch;

    /**
     * 可以实现ApplicationContextAware,重写setAppicationContext方法
     * 或者Autowired applicationContext
     * @param applicationContext
     * @throws BeansException
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        eventDispatch = new EventDispatch(applicationContext);

    }

    @Override
    public void processor(TaskModel taskModel) {
        eventDispatch.doDispatch(taskModel);
    }
}
