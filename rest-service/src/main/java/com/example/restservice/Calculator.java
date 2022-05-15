package com.example.restservice;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculator implements Serializable {

    private BigDecimal result;
    private final Float operating_A;

    private final Float operating_B;

    public Calculator(Float operating_A, Float operating_B) {
        this.operating_A = operating_A;
        this.operating_B = operating_B;
    }
    public void CalculatorSum(){this.result = BigDecimal.valueOf(operating_A).add(BigDecimal.valueOf(operating_B)).setScale(1, RoundingMode.HALF_UP);}
    public void CalculatorSub(){this.result = BigDecimal.valueOf(operating_A).subtract(BigDecimal.valueOf(operating_B)).setScale(1, RoundingMode.HALF_UP);}
    public void CalculatorMul(){this.result = BigDecimal.valueOf(operating_A).multiply(BigDecimal.valueOf(operating_B)).setScale(1, RoundingMode.HALF_UP);}
    public void CalculatorDiv(){this.result = BigDecimal.valueOf(operating_A).divide(BigDecimal.valueOf(operating_B)).setScale(1, RoundingMode.HALF_UP);}
    public String getResult() {return "{\n" + '"'+"result" +'"' + ": "  + result.toString() + "\n}";}
    public Float getOperating_A() {return operating_A;}
    public Float getOperating_B() {return operating_B;}
}
