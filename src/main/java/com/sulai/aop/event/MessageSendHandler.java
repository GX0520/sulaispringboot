package com.sulai.aop.event;

import com.sulai.aop.annotation.ChatTypeHand;
import com.sulai.aop.constant.ChatTypeConstant;
import com.sulai.aop.model.TaskModel;
import com.sulai.aop.supports.BaseEventHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author:sulai
 * @Date:2020/10/25 16:57
 * @Description:
 * @Version:1.0.0
 */
@ChatTypeHand(type= ChatTypeConstant.CANDIDATE_INITIALED_CHAT)
@Slf4j
public class MessageSendHandler extends BaseEventHandler {
    @Override
    public void execute(TaskModel taskModel) {
        log.info("type====CANDIDATE_INITIALED_CHAT");
    }
}
