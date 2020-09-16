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


    // pubSub start  ******************************************************
    /**
     * 创建队列
     */
    @Bean
    public Queue pubSubQueue1() {
        return new Queue("pubSubQueue1");
    }

    /**
     * 创建队列
     */
    @Bean
    public Queue pubSubQueue2() {
        return new Queue("pubSubQueue2");
    }

    /**
     * 创建扇形交换机
     */
    @Bean
    public FanoutExchange fanout() {
        return new FanoutExchange("FanoutExchange");
    }

    /**
     * 通过routingKey将队列和交换机绑定
     */
    @Bean
    public Binding bindingPubSubExchange1(){
        return BindingBuilder.bind(pubSubQueue1()).to(fanout());
    }

    /**
     * 通过routingKey将队列和交换机绑定
     */
    @Bean
    public Binding bindingPubSubExchange2(){
        return BindingBuilder.bind(pubSubQueue2()).to(fanout());
    }

    // pubsub end ******************************************************

}