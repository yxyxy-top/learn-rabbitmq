package com.rabbitmq.learn.confirm.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Rabbitmq配置
 *
 * @author XuYu
 * @date 2020/9/10 17:02
 */
@Configuration
public class RabbitmqConfig {


    // simple start  ******************************************************
    /**
     * 创建队列
     */
    @Bean
    public Queue simpleQueue() {
        return new Queue("simpleQueue");
    }

    // simple end ******************************************************

}