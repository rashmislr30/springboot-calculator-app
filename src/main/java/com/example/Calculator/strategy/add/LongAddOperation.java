package com.example.Calculator.strategy.add;

import com.example.Calculator.strategy.OperationStrategy;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LongAddOperation implements OperationStrategy {
    @Override
    public Number execute(Number num1, Number num2){
        if(num1 instanceof Long && num2 instanceof Long){
            long a=num1.longValue();
            long b=num2.longValue();
            if((a>0 && b>0 && a>Long.MAX_VALUE-b)||(a<0 && b<0 && a<Long.MIN_VALUE-b)){
                log.error("LongAddOperation: Long overflow for addtion");
                throw new ArithmeticException("LongAddOperation: Long overflow for addtion");
            }
            return a+b;
        }
        return null;
    }
}
