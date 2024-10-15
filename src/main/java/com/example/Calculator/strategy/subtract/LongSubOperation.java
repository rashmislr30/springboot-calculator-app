package com.example.Calculator.strategy.subtract;

import com.example.Calculator.strategy.OperationStrategy;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LongSubOperation implements OperationStrategy {
    @Override
    public Number execute(Number num1, Number num2){
        long a=num1.longValue();
        long b=num2.longValue();
        if((a<0 && b>0 && a<Long.MIN_VALUE+b)){
            log.error("LongSubOperation: Long underflow for subtraction");
            throw new ArithmeticException("LongSubOperation: Long underflow for subtraction");
        }
        if((a>0 && b<0 && a>Long.MAX_VALUE+b)){
            log.error("LongSubOperation: Long overflow for subtraction");
            throw new ArithmeticException("LongSubOperation: Long overflow for subtraction");
        }
        return a-b;
    }
}
