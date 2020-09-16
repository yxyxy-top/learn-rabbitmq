package com.rabbitmq.learn.topic.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

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

    private final String[] keys = {"quick.orange.rabbit", "lazy.orange.elephant", "quick.orange.fox",
            "lazy.brown.fox", "lazy.pink.rabbit", "quick.brown.fox"};

    AtomicInteger index = new AtomicInteger(0);

    @GetMapping("sendTopicQueue")
    public void sendTopicQueue(){
        for (int i = 0; i < keys.length; i++) {
            if (this.index.incrementAndGet() == keys.length) {
                this.index.set(0);
            }
            String key = keys[this.index.get()];
            rabbitTemplate.convertAndSend("tut.topic",key,"sendTopicQueue i = " +key);
        }
    }

}