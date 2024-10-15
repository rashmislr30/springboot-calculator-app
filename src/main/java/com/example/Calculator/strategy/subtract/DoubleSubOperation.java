package com.example.Calculator.strategy.subtract;

import com.example.Calculator.strategy.OperationStrategy;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DoubleSubOperation implements OperationStrategy {
    private static final double EPSLILON=1e-10;
    @Override
    public Number execute(Number num1, Number num2){
        double a=num1.doubleValue();
        double b=num2.doubleValue();
        if((Double.isNaN(a))||(Double.isNaN(b))){
            log.error("DoubleSubOperation: Invalid operation with NAN");
            throw new ArithmeticException("DoubleSubOperation: Invalid operation with NAN");
        }
        if((Double.isInfinite(a))||(Double.isInfinite(b))){
            log.error("DoubleSubOperation: Operation results in infinity");
            throw new ArithmeticException("DoubleSubOperation: Operation results in infinity");
        }
        double res=a-b;
        if((Double.isInfinite(res))||(Double.isNaN(res))){
            log.error("DoubleSubOperation: Double overflow/invalid for subtraction");
            throw new ArithmeticException("DoubleSubOperation: Double overflow/invalid for subtraction");
        }
        return Math.abs(res)<EPSLILON?0.0:res;
    }
}
