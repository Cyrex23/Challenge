package com.example.calculator.consumer;


import com.example.calculator.Calculator;
import com.example.calculator.dto.Numbers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


import java.io.Serializable;
import java.math.BigDecimal;

@Component
public class Consumer implements Serializable {

    static Logger logger = LoggerFactory.getLogger(Consumer.class);

    @RabbitListener(
            bindings = @QueueBinding(value = @Queue, exchange = @Exchange(value = "calculator_exchange", type = ExchangeTypes.TOPIC), key = "*.add"))
    public String addition(Numbers numbers){
        BigDecimal result = Calculator.CalculatorSum(numbers.getOperating_A(), numbers.getOperating_B());
        return result.toString();
    }
    @RabbitListener(
            bindings = @QueueBinding(value = @Queue, exchange = @Exchange(value = "calculator_exchange", type = ExchangeTypes.TOPIC), key = "*.sub"))
    public String subtraction(Numbers numbers){
        BigDecimal result = Calculator.CalculatorSub(numbers.getOperating_A(), numbers.getOperating_B());
        return result.toString();
    }
    @RabbitListener(
            bindings = @QueueBinding(value = @Queue, exchange = @Exchange(value = "calculator_exchange", type = ExchangeTypes.TOPIC), key = "*.div"))
    public String division(Numbers numbers){
        BigDecimal result = Calculator.CalculatorDiv(numbers.getOperating_A(), numbers.getOperating_B());
        return result.toString();
    }
    @RabbitListener(
            bindings = @QueueBinding(value = @Queue, exchange = @Exchange(value = "calculator_exchange", type = ExchangeTypes.TOPIC), key = "*.mul"))
    public String multiplication(Numbers numbers){
        BigDecimal result = Calculator.CalculatorMul(numbers.getOperating_A(), numbers.getOperating_B());
        return result.toString();
    }
}

