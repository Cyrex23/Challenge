package com.example.restservice.connections;


import com.example.restservice.constants.RabbitMQConstants;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.Serializable;

@Component
public class RabbitMQConnection implements Serializable {
    private static final String EXCHANGE_NAME = "amq.direct";
    private AmqpAdmin amqpAdmin;

    public RabbitMQConnection(AmqpAdmin amqpAdmin){
        this.amqpAdmin = amqpAdmin;
    }

    private Queue queue(String queueName){
        return new Queue(queueName, true, false, false);
    }

    private DirectExchange directExchange(){
        return new DirectExchange(EXCHANGE_NAME);
    }

    private Binding relation(Queue queue, DirectExchange exchange){
        return new Binding(queue.getName(), Binding.DestinationType.QUEUE, exchange.getName(), queue.getName(), null);
    }

    @PostConstruct
    private void add(){
        Queue queueResult = this.queue(RabbitMQConstants.QUEUE_RESULT);

        DirectExchange exchange = this.directExchange();

        Binding connectionResult = this.relation(queueResult, exchange);

        //Create queues in the RabbitMQ
        this.amqpAdmin.declareQueue(queueResult);

        this.amqpAdmin.declareExchange(exchange);

        this.amqpAdmin.declareBinding(connectionResult);
    }
}
