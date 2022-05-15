package com.example.calculator.consumer;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.calculator.constants.RabbitMQConstants;
import com.example.calculator.dto.ResultDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class Consumer implements Serializable {

    static Logger logger = LoggerFactory.getLogger(Consumer.class);

    @RabbitListener(queues = RabbitMQConstants.QUEUE_RESULT)
    private void receive(ResultDto resultDto){
        System.out.println(resultDto.getResultDto());
        logger.info("Received the result:" + resultDto.getResultDto());
    }
}
