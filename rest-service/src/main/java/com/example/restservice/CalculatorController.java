package com.example.restservice;

import com.example.restservice.constants.RabbitMQConstants;
import com.example.restservice.dto.Numbers;
import com.example.restservice.service.RabbitMQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

@RestController
public class CalculatorController implements Serializable {

    private Numbers numbers;

    @Autowired
    private RabbitMQService rabbitMQService;

    @GetMapping("/sum")
    public ResponseEntity getSum(@RequestParam("a")String num1, @RequestParam("b")String num2) {
        this.numbers = new Numbers(Float.parseFloat(num1),Float.parseFloat(num2));
        String result = this.rabbitMQService.sendMessage(RabbitMQConstants.QUEUE_ADD, this.numbers);
        return new ResponseEntity(result,HttpStatus.OK);
    }
    @GetMapping("/sub")
    public ResponseEntity getSub(@RequestParam("a")String num1, @RequestParam("b")String num2) {
        this.numbers = new Numbers(Float.parseFloat(num1),Float.parseFloat(num2));
        String result = this.rabbitMQService.sendMessage(RabbitMQConstants.QUEUE_SUB, this.numbers);
        return new ResponseEntity(result,HttpStatus.OK);
    }
    @GetMapping("/mul")
    public ResponseEntity getMul(@RequestParam("a")String num1, @RequestParam("b")String num2) {
        this.numbers = new Numbers(Float.parseFloat(num1),Float.parseFloat(num2));
        String result = this.rabbitMQService.sendMessage(RabbitMQConstants.QUEUE_MUL, this.numbers);
        return new ResponseEntity(result,HttpStatus.OK);
    }
    @GetMapping("/div")
    public ResponseEntity getDiv(@RequestParam("a")String num1, @RequestParam("b")String num2) {
        this.numbers = new Numbers(Float.parseFloat(num1),Float.parseFloat(num2));
        String result = this.rabbitMQService.sendMessage(RabbitMQConstants.QUEUE_DIV, this.numbers);
        return new ResponseEntity(result,HttpStatus.OK);
    }
}
