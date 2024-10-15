package com.example.Calculator.strategy.divide;
import com.example.Calculator.strategy.OperationStrategy;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IntegerDivOperation implements OperationStrategy {
    @Override
    public Number execute(Number num1, Number num2){
        int a=num1.intValue();
        int b=num2.intValue();
        if(b==0){
            log.error("IntegerDivOperation: Divide by zero not allowed");
            throw new ArithmeticException("IntegerDivOperation: Divide by zero not allowed");
        }
        if(a==Integer.MIN_VALUE && b==-1){
            log.error("IntegerDivOperation: Integer overflow in division");
            throw new ArithmeticException("IntegerDivOperation: Integer overflow in division");
        }
        return (double)a/b;
    }
}
