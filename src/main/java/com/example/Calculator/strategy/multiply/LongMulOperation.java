package com.example.Calculator.strategy.multiply;

import com.example.Calculator.strategy.OperationStrategy;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LongMulOperation implements OperationStrategy {
    @Override
    public Number execute(Number num1, Number num2){
        long a=num1.longValue();
        long b=num2.longValue();
        if(a==0||b==0){
            return 0L;
        }
        if((a>0 && b>0 && a>Long.MAX_VALUE/b)||(a<0 && b<0 && a<Long.MAX_VALUE/b)||((a<0 && b>0 && a<Long.MIN_VALUE/b))||(a>0 && b<0 && b<Long.MIN_VALUE/a)){
            log.error("LongMulOperation: Long overflow for multiplication");
            throw new ArithmeticException("LongMulOperation: Long overflow for multiplication");
        }
        return a*b;
    }
}
