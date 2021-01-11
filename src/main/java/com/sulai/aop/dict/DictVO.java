package com.sulai.aop.dict;

import lombok.Builder;
import lombok.Data;

/**
 * @author :sulai
 * @version :1.0.0
 * @date :2021/1/8 23:29
 * @description: description
 */
@Data
@Builder
@DictCheck
public class DictVO {
    private Integer id;

    private Integer channelId;

    @DictMapping
    private String channel;

    @DictCheck
    private Education education;
}
