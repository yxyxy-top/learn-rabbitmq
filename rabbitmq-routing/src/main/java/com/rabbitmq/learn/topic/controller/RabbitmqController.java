package com.rabbitmq.learn.topic.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试方法Controller
 *
 * @author XuYu
 * @date 2020/9/10 17:00
 */
@RestController
public class RabbitmqController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("sendRoutingQueue")
    public void sendRoutingQueue(){
        String routingKey;
        for (int i = 0; i < 10; i++) {
            if (i%2==0){
                routingKey = "routingRoutingKey1";
            }else {
                routingKey = "routingRoutingKey2";
            }
            rabbitTemplate.convertAndSend("routingExchange",routingKey,"sendRoutingQueue i = " +i);
        }
    }

}