package com.example.calculator;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculator implements Serializable {

    public static BigDecimal CalculatorSum(Float operating_A, Float operating_B){return BigDecimal.valueOf(operating_A).add(BigDecimal.valueOf(operating_B)).setScale(1, RoundingMode.HALF_UP);}
    public static BigDecimal CalculatorSub(Float operating_A, Float operating_B){return BigDecimal.valueOf(operating_A).subtract(BigDecimal.valueOf(operating_B)).setScale(1, RoundingMode.HALF_UP);}
    public static BigDecimal CalculatorMul(Float operating_A, Float operating_B){return BigDecimal.valueOf(operating_A).multiply(BigDecimal.valueOf(operating_B)).setScale(1, RoundingMode.HALF_UP);}
    public static BigDecimal CalculatorDiv(Float operating_A, Float operating_B){return BigDecimal.valueOf(operating_A).divide(BigDecimal.valueOf(operating_B)).setScale(1, RoundingMode.HALF_UP);}

}
