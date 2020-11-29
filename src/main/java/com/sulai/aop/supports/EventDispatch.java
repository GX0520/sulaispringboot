package com.sulai.aop.supports;

import com.sulai.aop.model.TaskModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author:sulai
 * @Date:2020/10/25 19:08
 * @Description: 装配所有的bean
 * @Version:1.0.0
 */
@Slf4j
//@Component
public class EventDispatch {
    ConcurrentHashMap<String, Set<EventHandler>> handlerMap = new ConcurrentHashMap<>();

    private ApplicationContext applicationContext;

    public EventDispatch(ApplicationContext applicationContext) {
        this.applicationContext=applicationContext;
        initBean();
    }

    private void initBean() {
        Map<String, EventHandler> beansOfType = applicationContext.getBeansOfType(EventHandler.class);
        for (EventHandler handler : beansOfType.values()) {
            String eventType = handler.getEventType();
            if (StringUtils.isEmpty(eventType)) {
                throw new IllegalArgumentException("eventType must can't be null");
            }

            Set<EventHandler> eventHandlers = handlerMap.get(eventType);
            if (CollectionUtils.isEmpty(eventHandlers)) {
                eventHandlers = new HashSet<>();
                handlerMap.put(eventType, eventHandlers);
            }

            eventHandlers.add(handler);
        }
    }

    public void doDispatch(TaskModel taskModel) {
        String eventType = taskModel.getEventType();
        Set<EventHandler> eventHandlers = handlerMap.get(eventType);
        if (eventHandlers == null) {
            log.info("no eventType be found {},nothing will be down",eventType);
            return;
        }

        for (EventHandler eventHandler : eventHandlers) {
            eventHandler.execute(taskModel);
        }

    }
}
