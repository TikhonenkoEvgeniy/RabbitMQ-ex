package com.example.rmqtest;

import com.example.rmqtest.config.MQConfig;
import com.example.rmqtest.dto.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    @RabbitListener(queues = MQConfig.QUEUE)
    public void listener(Message message) {
        System.out.println(message);
    }
}
