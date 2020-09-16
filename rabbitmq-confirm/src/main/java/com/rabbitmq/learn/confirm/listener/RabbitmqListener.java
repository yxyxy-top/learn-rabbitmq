package com.rabbitmq.learn.confirm.listener;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Rabbitmq监听
 *
 * @author XuYu
 * @date 2020/9/10 17:31
 */
@Component
public class RabbitmqListener {

    @RabbitListener(queues = "confirmQueue")
    public void confirmQueueListener(@Payload String message,
                                     @Headers Map<String, Object> headers,
                                     Channel channel) {
        System.out.println("message = " + message);
        System.out.println("headers = " + headers.toString());
        System.out.println("Channel = " + channel.toString());
    }

}