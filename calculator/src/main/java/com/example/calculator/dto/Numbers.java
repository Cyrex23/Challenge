package com.example.calculator.dto;

import java.io.Serializable;

public class Numbers implements Serializable {
    //public String resultDto;
    private  Float operating_A;

    private  Float operating_B;

    public void setOperating_A(Float operating_A) {
        this.operating_A = operating_A;
    }

    public void setOperating_B(Float operating_B) {
        this.operating_B = operating_B;
    }

    public Numbers(){}
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
