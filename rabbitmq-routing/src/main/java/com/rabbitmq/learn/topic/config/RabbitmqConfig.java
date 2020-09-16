package com.rabbitmq.learn.topic.config;

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


    // routing start  ******************************************************
    /**
     * 创建队列
     */
    @Bean
    public Queue routingQueue1() {
        return new Queue("routingQueue1");
    }

    /**
     * 创建队列
     */
    @Bean
    public Queue routingQueue2() {
        return new Queue("routingQueue2");
    }

    /**
     * 创建定向交换机
     */
    @Bean
    public DirectExchange routingExchange() {
        return new DirectExchange("routingExchange");
    }

    /**
     * 通过routingKey将队列和交换机绑定
     */
    @Bean
    public Binding bindingRoutingExchange1a(){
        return BindingBuilder.bind(routingQueue1()).to(routingExchange()).with("routingRoutingKey1");
    }


    /**
     * 通过routingKey将队列和交换机绑定
     */
    @Bean
    public Binding bindingRoutingExchange2b(){
        return BindingBuilder.bind(routingQueue2()).to(routingExchange()).with("routingRoutingKey2");
    }

    // routing end ******************************************************

}