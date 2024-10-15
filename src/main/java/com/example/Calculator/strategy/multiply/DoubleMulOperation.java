package com.example.Calculator.strategy.multiply;

import com.example.Calculator.strategy.OperationStrategy;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DoubleMulOperation implements OperationStrategy {
    @Override
    public Number execute(Number num1, Number num2){
        double a=num1.doubleValue();
        double b=num2.doubleValue();
        if(a==0.0||b==0.0){
            return 0.0;
        }
        if((Double.isNaN(a))||(Double.isNaN(b))){
            log.error("DoubleMulOperation: Invalid operation with NAN");
            throw new ArithmeticException("DoubleMulOperation: Invalid operation with NAN");
        }
        if((Double.isInfinite(a))||(Double.isInfinite(b))){
            log.error("DoubleMulOperation: Operation results in infinity");
            throw new ArithmeticException("DoubleMulOperation: Operation results in infinity");
        }
        double res=a*b;
        if((Double.isInfinite(res))||(Double.isNaN(res))){
            log.error("DoubleMulOperation: Double overflow/invalid for multiplication");
            throw new ArithmeticException("DoubleMulOperation: Double overflow/invalid for multiplication");
        }
        return res;
    }
}
