package com.rabbitmq.learn.topic.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Rabbitmq监听
 *
 * @author XuYu
 * @date 2020/9/10 17:31
 */
@Component
public class RabbitmqListener {

    @RabbitListener(queues = "pubSubQueue1")
    public void pubsubQueueListenerOne(String msg){
        System.out.println("pubsubQueueListenerOne = "+msg);
    }

    @RabbitListener(queues = "pubSubQueue2")
    public void pubsubQueueListenerTwo(String msg){
        System.out.println("pubsubQueueListenerTwo = "+msg);
    }

}