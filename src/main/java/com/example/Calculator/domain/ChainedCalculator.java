package com.example.Calculator.domain;

import com.example.Calculator.model.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ChainedCalculator {
    private final Calculator calculator;
    private Number currentValue;
    public ChainedCalculator(Calculator calculator){
        this.calculator=calculator;
    }
    public ChainedCalculator start(Number initialValue){
        this.currentValue=initialValue;
        return this;
    }
    public ChainedCalculator apply(Operation op, Number num){
        log.info("ChainedCalculator: applying operation: {}, operand: {}",op,num);
        currentValue=calculator.calculate(op,currentValue,num);
        return this;
    }
    public Number getResult(){
        return currentValue;
    }

}
