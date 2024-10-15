package com.example.Calculator.strategy.add;

import com.example.Calculator.strategy.OperationStrategy;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IntegerAddOperation implements OperationStrategy {
    @Override
    public Number execute(Number num1, Number num2){
        if(num1 instanceof Integer && num2 instanceof Integer){
            int a=num1.intValue();
            int b=num2.intValue();
            if((a>0 && b>0 && a>Integer.MAX_VALUE-b)||(a<0 && b<0 && a<Integer.MIN_VALUE-b)){
                log.error("IntegerAddOperation: Integer overflow");
                throw new ArithmeticException("IntegerAddOperation: Integer overflow for addition");
            }
            return a+b;
        }
        return null;
    }
}
