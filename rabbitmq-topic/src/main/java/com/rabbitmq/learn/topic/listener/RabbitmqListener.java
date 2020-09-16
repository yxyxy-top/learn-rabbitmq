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

    @RabbitListener(queues = "topicQueue1")
    public void topicQueueListenerOne(Object ob,String msg){
        System.out.println("topicQueueListenerOne = "+msg);
    }

    @RabbitListener(queues = "topicQueue2")
    public void topicQueueListenerTwo(Object ob,String msg){
        System.out.println("topicQueueListenerTwo = "+msg);
    }

}