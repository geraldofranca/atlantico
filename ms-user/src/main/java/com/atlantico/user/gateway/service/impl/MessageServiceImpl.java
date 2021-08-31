package com.atlantico.user.gateway.service.impl;

import com.atlantico.user.gateway.service.MessageService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void sendMessage(String queue, Object message) {
        this.rabbitTemplate.convertAndSend(queue, message);
    }
}
