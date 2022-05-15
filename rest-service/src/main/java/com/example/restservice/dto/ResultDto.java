package com.example.restservice.dto;

import java.io.Serializable;

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
