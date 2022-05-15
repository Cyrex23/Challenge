package com.example.restservice;

import com.example.restservice.constants.RabbitMQConstants;
import com.example.restservice.dto.ResultDto;
import com.example.restservice.service.RabbitMQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

@RestController
//@RequestMapping(value = "sum")
public class CalculatorController implements Serializable {

    private ResultDto resultDto;

    @Autowired
    private RabbitMQService rabbitMQService;

    @PutMapping
    private ResponseEntity calculate(@RequestBody ResultDto resultDto){
        System.out.println(resultDto.resultDto);
        this.rabbitMQService.sendMessage(RabbitMQConstants.QUEUE_RESULT, resultDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/sum")
    public ResponseEntity getSum(@RequestParam("a")String num1, @RequestParam("b")String num2) {
        Calculator c = new Calculator(Float.parseFloat(num1),Float.parseFloat(num2));
        c.CalculatorSum();
        this.resultDto = new ResultDto(c.getResult());
        this.rabbitMQService.sendMessage(RabbitMQConstants.QUEUE_RESULT, this.resultDto);
        return new ResponseEntity(HttpStatus.OK);
        //return c.getResult();
    }
    @GetMapping("/sub")
    public String getSub(@RequestParam("a")String num1, @RequestParam("b")String num2) {
        Calculator c = new Calculator(Float.parseFloat(num1),Float.parseFloat(num2));
        c.CalculatorSub();
        return c.getResult();
    }
    @GetMapping("/mul")
    public String getMul(@RequestParam("a")String num1, @RequestParam("b")String num2) {
        Calculator c = new Calculator(Float.parseFloat(num1),Float.parseFloat(num2));
        c.CalculatorMul();
        return c.getResult();
    }
    @GetMapping("/div")
    public String getDiv(@RequestParam("a")String num1, @RequestParam("b")String num2) {
        Calculator c = new Calculator(Float.parseFloat(num1),Float.parseFloat(num2));
        c.CalculatorDiv();
        return c.getResult();
    }
}
