package com.rabbitmq.learn.rpc.controller;

import org.springframework.amqp.core.DirectExchange;
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

    @Autowired
    private DirectExchange exchange;

    int start = 0;

    @GetMapping("sendRpcQueue")
    public void sendRpcQueue() {
        for (int i = 0; i < 10; i++) {
            System.out.println(" [x] Requesting fib(" + start + ")");
            Integer response = (Integer) rabbitTemplate.convertSendAndReceive(exchange.getName(), "rpc", start++);
            System.out.println(" [.] Got '" + response + "'");
        }
    }

}