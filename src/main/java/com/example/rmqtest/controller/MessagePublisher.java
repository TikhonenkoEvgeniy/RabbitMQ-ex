package com.example.rmqtest.controller;

import com.example.rmqtest.config.MQConfig;
import com.example.rmqtest.dto.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class MessagePublisher {
    private final RabbitTemplate template;

    @PostMapping("/publish")
    public String publishMessage(@RequestBody Message message) {
        message.setId(UUID.randomUUID().toString());
        message.setDate(new Date());
        template.convertAndSend(MQConfig.EXCHANGE, MQConfig.ROUTING_KEY, message);
        return "message published";
    }
}
