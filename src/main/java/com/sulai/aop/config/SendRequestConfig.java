package com.sulai.aop.config;

import com.sulai.aop.supports.EventDefaultProcessor;
import com.sulai.aop.supports.SendRequestProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author:sulai
 * @Date:2020/10/25 23:50
 * @Description:
 * @Version:1.0.0
 */
@Configuration
public class SendRequestConfig {

    @Bean
    SendRequestProcessor sendRequest() {
        return new EventDefaultProcessor();
    }
}
