package com.sulai.aop.supports;

import com.sulai.aop.model.TaskModel;

/**
 * @Author:sulai
 * @Date:2020/10/25 16:22
 * @Description:
 * @Version:1.0.0
 */
public  interface EventHandler {
    String getEventType();

    void execute(TaskModel taskModel);
}
