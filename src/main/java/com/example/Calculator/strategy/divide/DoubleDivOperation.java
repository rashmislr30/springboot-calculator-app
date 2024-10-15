package com.example.Calculator.strategy.divide;

import com.example.Calculator.strategy.OperationStrategy;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DoubleDivOperation implements OperationStrategy {
    @Override
    public Number execute(Number num1, Number num2){
        double a=num1.doubleValue();
        double b=num2.doubleValue();
        if(b==0.0){
            log.error("DoubleDivOperation: Division by zero is not allowed");
            throw new ArithmeticException("DoubleDivOperation: Division by zero is not allowed");
        }
        if((Double.isNaN(a))||(Double.isNaN(b))){
            log.error("DoubleDivOperation: Invalid operation with NAN");
            throw new ArithmeticException("DoubleDivOperation: Invalid operation with NAN");
        }
        if((Double.isInfinite(a))||(Double.isInfinite(b))){
            log.error("DoubleDivOperation: Operation results in infinity");
            throw new ArithmeticException("DoubleDivOperation: Operation results in infinity");
        }
        return (double)a/b;
    }
}
