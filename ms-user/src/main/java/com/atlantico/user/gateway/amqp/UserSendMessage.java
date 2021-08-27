package com.atlantico.user.gateway.amqp;

import com.atlantico.user.http.dto.UserDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserSendMessage {

    @Value("${user.rabbitmq.exchange}")
    String exchange;

    @Value("${user.rabbitmq.routingkey}")
    String routingKey;

    public final RabbitTemplate rabbitTemplate;

    public UserSendMessage(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(UserDTO userDTO) {
        rabbitTemplate.convertAndSend(exchange, routingKey, userDTO);
    }
}
