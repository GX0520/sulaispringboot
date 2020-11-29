package com.sulai.aop.supports;

import com.sulai.aop.model.TaskModel;

/**
 * @Author:sulai
 * @Date:2020/10/25 23:19
 * @Description:
 * @Version:1.0.0
 */
public interface SendRequestProcessor {
    void processor(TaskModel taskModel);
}
