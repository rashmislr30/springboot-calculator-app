package com.example.Calculator.exception;

import lombok.Data;

@Data
public class CalculationException extends RuntimeException{
    public CalculationException(String msg){
        super(msg);
    }
    public CalculationException(String msg,Throwable cause){
        super(cause);
    }
    public CalculationException(Throwable cause){
        super(cause);
    }
}
