package com.rabbitmq.learn.confirm.controller;

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

    @GetMapping("sendSimpleQueue")
    public void sendSimpleQueue(){
        rabbitTemplate.convertAndSend("simpleQueue",new StringBuffer("sendSimpleQueue"));
    }

}