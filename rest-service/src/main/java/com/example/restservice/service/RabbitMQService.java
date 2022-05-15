package com.example.restservice.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class RabbitMQService implements Serializable {
    //Permite que o spring resolve e injete a classe(bean) instanciando o objecto.

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public String sendMessage(String queueName, Object message){
        return (String) this.rabbitTemplate.convertSendAndReceive("calculator_exchange", queueName, message);
    }
}
