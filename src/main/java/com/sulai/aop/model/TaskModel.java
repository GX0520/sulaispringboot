package com.sulai.aop.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author:sulai
 * @Date:2020/10/25 15:44
 * @Description:
 * @Version:1.0.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskModel {
    /**
     * 事件类型
     */
    private String eventType;

    /**
     * 自定义消息类型
     */
    private String custom_type;

    private String type;

    private String sendUser;

    private String member;

    private String channel;
}
