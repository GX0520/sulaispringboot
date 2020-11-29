package com.sulai.aop.supports;

import com.sulai.aop.annotation.ChatTypeHand;

/**
 * @Author:sulai
 * @Date:2020/10/25 16:22
 * @Description: 如果自己实现了某个类,又不想自己去实现,可以用abstract 抛给子类去实现
 * @Version:1.0.0
 */
public abstract class BaseEventHandler implements EventHandler{

    private String eventType;

    public BaseEventHandler() {
        ChatTypeHand annotation = this.getClass().getAnnotation(ChatTypeHand.class);
        if (annotation != null) {
            this.eventType = annotation.type();
        }
    }

    @Override
    public String getEventType() {
        return this.eventType;
    }

}
