package com.rabbitmq.learn.topic.config;

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


    // work start  ******************************************************
    /**
     * 创建队列
     */
    @Bean
    public Queue workQueue() {
        return new Queue("workQueue");
    }

    // work end ******************************************************

}