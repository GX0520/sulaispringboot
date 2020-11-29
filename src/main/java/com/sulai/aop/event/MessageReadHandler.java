package com.sulai.aop.event;

import com.sulai.aop.annotation.ChatTypeHand;
import com.sulai.aop.constant.ChatTypeConstant;
import com.sulai.aop.model.TaskModel;
import com.sulai.aop.supports.BaseEventHandler;
import com.sulai.aop.supports.EventDispatch;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @Author:sulai
 * @Date:2020/10/25 16:57
 * @Description:
 * @Version:1.0.0
 */
@ChatTypeHand(type=ChatTypeConstant.CANDIDATE_READE_MESSAGE)
@Slf4j
public class MessageReadHandler extends BaseEventHandler {

    /// 写了这个之后,spring getbeanOfType就找不到了,采用自动化转配
//    private EventDispatch eventDispatch;
//
//    public MessageReadHandler(ApplicationContext applicationContext) {
//        eventDispatch = new EventDispatch(applicationContext);
//    }

    @Override
    public void execute(TaskModel taskModel) {
        log.info("type===CANDIDATE_READE_MESSAGE");
    }
}
