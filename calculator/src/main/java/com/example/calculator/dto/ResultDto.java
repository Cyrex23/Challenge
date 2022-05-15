package com.example.calculator.dto;

import java.io.Serializable;

//dto = data transfer objecto
public class ResultDto implements Serializable {
    public String resultDto;

    public ResultDto(String resultDto) {
        this.resultDto = resultDto;
    }

    public String getResultDto() {
        return resultDto;
    }

    public void setResultDto(String resultDto) {
        this.resultDto = resultDto;
    }
}