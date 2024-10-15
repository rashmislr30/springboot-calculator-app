package com.example.Calculator.strategy.subtract;

import com.example.Calculator.strategy.OperationStrategy;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IntegerSubOperation implements OperationStrategy {
    @Override
    public Number execute(Number num1, Number num2){
        int a=num1.intValue();
        int b=num2.intValue();
        if((a<0 && b>0 && a<Integer.MIN_VALUE+b)){
            log.error("IntegerSubOperation: Integer underflow for subtraction");
            throw new ArithmeticException("IntegerSubOperation: Integer underflow for subtraction");
        }
        if((a>0 && b<0 && a>Integer.MAX_VALUE+b)){
            log.error("IntegerSubOperation: Integer overflow for subtraction");
            throw new ArithmeticException("IntegerSubOperation: Integer overflow for subtraction");
        }
        return a-b;
    }
}
