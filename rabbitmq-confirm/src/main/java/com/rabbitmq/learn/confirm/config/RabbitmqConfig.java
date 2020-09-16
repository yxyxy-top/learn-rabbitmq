package com.rabbitmq.learn.confirm.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
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


    // confirm start  ******************************************************
    /**
     * 创建队列
     */
    @Bean
    public Queue confirmQueue() {
        return new Queue("confirmQueue");
    }

    /**
     * 创建交换机
     */
    @Bean
    public DirectExchange confirmExchange(){
        return new DirectExchange("confirmExchange");
    }

    /**
     * 绑定队列和交换机
     */
    @Bean
    public Binding bindConfirmExchange(){
        return BindingBuilder.bind(confirmQueue()).to(confirmExchange()).with("confirmRoutingKey");
    }

    // confirm end ******************************************************

}