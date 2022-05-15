package com.example.restservice.dto;

import java.io.Serializable;

public class Numbers implements Serializable {
    //public String resultDto;
    private final Float operating_A;

    private final Float operating_B;

    public Numbers(Float operating_A, Float operating_B) {
        this.operating_A = operating_A;
        this.operating_B = operating_B;
    }

    public Float getOperating_A() {
        return operating_A;
    }

    public Float getOperating_B() {
        return operating_B;
    }
}
