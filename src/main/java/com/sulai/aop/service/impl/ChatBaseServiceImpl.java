package com.sulai.aop.service.impl;

import com.sulai.aop.annotation.PushTask;
import com.sulai.aop.model.TaskModel;
import com.sulai.aop.supports.SendRequestProcessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author:sulai
 * @Date:2020/10/25 15:15
 * @Description:
 * @Version:1.0.0
 */
@Service
@Slf4j
public class ChatBaseServiceImpl {

    private final SendRequestProcessor sendRequestProcessor;

    @Autowired
    public ChatBaseServiceImpl(SendRequestProcessor sendRequestProcessor) {
        this.sendRequestProcessor = sendRequestProcessor;
    }

   public void doHandMessage(TaskModel taskModel) {
        sendRequestProcessor.processor(taskModel);
    }

    @PushTask()
   public void testPushTashAnnotation() {
        log.info("调用task 方法success   ===");
    }

}
