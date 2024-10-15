package com.example.Calculator.strategy.divide;
import com.example.Calculator.strategy.OperationStrategy;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LongDivOperation implements OperationStrategy {
    @Override
    public Number execute(Number num1, Number num2){
        long a=num1.longValue();
        long b=num2.longValue();
        if(b==0){
            log.error("LongDivOperation: Divide by zero not allowed");
            throw new ArithmeticException("LongDivOperation: Divide by zero not allowed");
        }
        if(a==Long.MIN_VALUE && b==-1){
            log.error("LongDivOperation: Long overflow in division");
            throw new ArithmeticException("LongDivOperation: Long overflow in division");
        }
        return (double)a/b;
    }
}
