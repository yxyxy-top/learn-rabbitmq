package com.rabbitmq.learn.confirm.listener;

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

    @RabbitListener(queues = "simpleQueue")
    public void simpleQueueListener(String msg){
        System.out.println("simpleQueueListener = "+msg);
    }

}