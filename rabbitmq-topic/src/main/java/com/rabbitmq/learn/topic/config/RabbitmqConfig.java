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


    // topic start ******************************************************
    /**
     * 创建队列
     */
    @Bean
    public Queue topicQueue1() {
        return new Queue("topicQueue1");
    }

    /**
     * 创建队列
     */
    @Bean
    public Queue topicQueue2() {
        return new Queue("topicQueue2");
    }

    /**
     * 创建topic交换机
     */
    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange("tut.topic");
    }

    /**
     * 通过routingKey将队列和交换机绑定
     */
    @Bean
    public Binding bindingTopicExchange1a(){
        return BindingBuilder.bind(topicQueue1()).to(topicExchange()).with("*.orange.*");
    }


    /**
     * 通过routingKey将队列和交换机绑定
     */
    @Bean
    public Binding bindingTopicExchange1b(){
        return BindingBuilder.bind(topicQueue1()).to(topicExchange()).with("*.*.rabbit");
    }

    /**
     * 通过routingKey将队列和交换机绑定
     */
    @Bean
    public Binding bindingTopicExchange1c(){
        return BindingBuilder.bind(topicQueue2()).to(topicExchange()).with("lazy.#");
    }

    // topic end ******************************************************

}