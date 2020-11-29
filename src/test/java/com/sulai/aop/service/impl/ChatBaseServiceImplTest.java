package com.sulai.aop.service.impl;

import com.sulai.aop.constant.ChatTypeConstant;
import com.sulai.aop.model.TaskModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author:sulai
 * @Date:2020/10/25 23:40
 * @Description:
 * @Version:1.0.0
 */
@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ChatBaseServiceImplTest {

    @Autowired
    ChatBaseServiceImpl chatBaseService;

    @Test
    void doHandMessageTest() {
        TaskModel taskModel = new TaskModel();
        taskModel.setEventType(ChatTypeConstant.CANDIDATE_INITIALED_CHAT);
        chatBaseService.doHandMessage(taskModel);
    }
}
