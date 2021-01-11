package com.sulai.aop.dict;

import lombok.Data;

/**
 * @author :sulai
 * @version :1.0.0
 * @date :2021/1/11 11:08
 * @description: description
 */
@DictCheck
@Data
public class Education {

    private Integer educationId;

    @DictMapping
    private String education;

}
