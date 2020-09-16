package com.rabbitmq.learn.rpc.listener;

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

    @RabbitListener(queues = "tut.rpc.requests")
    public int rpcQueueListenerOne(int n){
        System.out.println(" [x] Received request for " + n);
        int result = fib(n);
        System.out.println(" [.] Returned " + result);
        return result;
    }

    public int fib(int n) {
        return n == 0 ? 0 : n == 1 ? 1 : (fib(n - 1) + fib(n - 2));
    }

}