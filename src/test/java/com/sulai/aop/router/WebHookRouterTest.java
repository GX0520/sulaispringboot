package com.sulai.aop.router;

import com.sulai.aop.model.TaskModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

/**
 * @Author:sulai
 * @Date:2020/10/25 23:39
 * @Description:
 * @Version:1.0.0
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient(timeout = "60000")
public class WebHookRouterTest {

    @Autowired
    WebTestClient webTestClient;


    @Value("${server.servlet.context-path}")
    String contentPath;

    @Test
    void sendMessageTest() {
        TaskModel taskModel = TaskModel.builder()
                .eventType("candidate_reade_chat")
                .channel("hello test")
                .sendUser("123")
                .build();
        webTestClient.post()
                .uri(contentPath+"/webHook")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(taskModel)
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody().consumeWith(System.out::print);

    }

    @Test
    void doPushTask() {
        webTestClient.post()
                .uri(contentPath+"/pushTask")
                .contentType(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody().consumeWith(System.out::print);

    }
}
