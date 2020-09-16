package com.rabbitmq.learn.rpc.config;

import org.springframework.amqp.core.*;
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


    // rpc start  ******************************************************
    /**
     * 创建队列
     */
    @Bean
    public Queue queue() {
        return new Queue("tut.rpc.requests");
    }

    /**
     * 创建rpc交换机
     */
    @Bean
    public DirectExchange exchange() {
        return new DirectExchange("tut.rpc");
    }

    /**
     * 通过routingKey将队列和交换机绑定
     */
    @Bean
    public Binding binding(DirectExchange exchange,
                           Queue queue) {
        return BindingBuilder.bind(queue)
                .to(exchange)
                .with("rpc");
    }

    // rpc end ******************************************************

}