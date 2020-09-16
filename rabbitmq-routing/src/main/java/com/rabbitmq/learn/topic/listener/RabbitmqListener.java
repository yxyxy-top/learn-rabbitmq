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

    @RabbitListener(queues = "routingQueue1")
    public void routingQueueListenerOne(Object ob,String msg){
        System.out.println("routingQueueListenerOne = "+msg);
    }

    @RabbitListener(queues = "routingQueue2")
    public void routingQueueListenerTwo(Object ob,String msg){
        System.out.println("routingQueueListenerTwo = "+msg);
    }

}