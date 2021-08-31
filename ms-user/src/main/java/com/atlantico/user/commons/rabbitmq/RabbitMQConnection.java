package com.atlantico.user.commons.rabbitmq;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class RabbitMQConnection {

    private static final String NAME_EXCHANGE = "amq.direct";
    private static final String QUEUE_USER = "USER";
    private AmqpAdmin amqpAdmin;

    public RabbitMQConnection(AmqpAdmin amqpAdmin) {
        this.amqpAdmin = amqpAdmin;
    }

    private Queue queue(String nameQueue) {
        return new Queue(nameQueue, true, false, false);
    }

    private DirectExchange directExchange() {
        return new DirectExchange(NAME_EXCHANGE);
    }

    private Binding relationship(Queue queue, DirectExchange directExchange) {
        return new Binding(queue.getName(),
                Binding.DestinationType.QUEUE,
                directExchange.getName(),
                queue.getName(),
                null);
    }

    @PostConstruct
    private void add() {
        Queue queueUser = this.queue(QUEUE_USER);
        DirectExchange directExchange = this.directExchange();
        Binding linkUser = this.relationship(queueUser, directExchange);

        this.amqpAdmin.declareQueue(queueUser);
        this.amqpAdmin.declareExchange(directExchange);
        this.amqpAdmin.declareBinding(linkUser);
    }
}
