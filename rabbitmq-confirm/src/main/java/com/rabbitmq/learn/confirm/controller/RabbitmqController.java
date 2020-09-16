package com.rabbitmq.learn.confirm.controller;

import org.springframework.amqp.rabbit.connection.CorrelationData;
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

    @GetMapping("sendConfirmQueue")
    public void sendConfirmQueue() {
        rabbitTemplate.convertAndSend("confirmExchange","confirmRoutingKey", new StringBuffer("sendConfirmQueue"), new CorrelationData(System.currentTimeMillis() + ""));
        rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {
            if (ack) {
                System.out.println("confirmCallback true 消息确认成功 " + correlationData + " , cause: " + cause);
            } else {
                System.out.println("confirmCallback false 消息确认失败 " + correlationData + " , cause: " + cause);
            }
        });
        rabbitTemplate.setReturnCallback((message, replyCode, replyText, exchange, routingKey) -> System.out.println("returnCallback message: " + message + ", replyCode: " + replyCode + ", replyText: " + replyText + ", exchange: " + exchange + ", routingKey: " + routingKey));
    }

}