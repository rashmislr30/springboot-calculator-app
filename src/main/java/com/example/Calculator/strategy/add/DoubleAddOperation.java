package com.example.Calculator.strategy.add;

import com.example.Calculator.strategy.OperationStrategy;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DoubleAddOperation implements OperationStrategy {
    @Override
    public Number execute(Number num1, Number num2){
            double a=num1.doubleValue();
            double b=num2.doubleValue();
            double res=a+b;
            if((Double.isInfinite(res))||(Double.isNaN(res))){
                log.error("DoubleAddOperation: Double overflow/Invalid for addition");
                throw new ArithmeticException("DoubleAddOperation: Double overflow/Invalid for addition");
            }
            return res;
    }
}
