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

    @RabbitListener(queues = "workQueue")
    public void workQueueListenerOne(String msg){
        System.out.println("workQueueListenerOne = "+msg);
    }

    @RabbitListener(queues = "workQueue")
    public void workQueueListenerTwo(String msg){
        System.out.println("workQueueListenerTwo = "+msg);
    }

}