package com.example.Calculator.strategy.multiply;

import com.example.Calculator.strategy.OperationStrategy;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IntegerMulOperation implements OperationStrategy {
    @Override
    public Number execute(Number num1, Number num2){
            int a=num1.intValue();
            int b=num2.intValue();
            if(a==0||b==0){
                return 0;
            }
            if((a>0 && b>0 && a>Integer.MAX_VALUE/b)||(a<0 && b<0 && a<Integer.MAX_VALUE/b)||((a<0 && b>0 && a<Integer.MIN_VALUE/b))||(a>0 && b<0 && b<Integer.MIN_VALUE/a)){
                log.error("IntegerMulOperation: Integer overflow for multiplication");
                throw new ArithmeticException("IntegerMulOperation: Integer overflow for multiplication");
            }
            return a*b;
    }
}
