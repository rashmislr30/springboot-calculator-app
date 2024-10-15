package com.example.Calculator.domain;

import com.example.Calculator.model.Operation;
import com.example.Calculator.strategy.OperationStrategy;
import com.example.Calculator.strategy.StrategyFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class Calculator {
    public Number calculate(Operation o, Number n1, Number n2){
        log.info("received operation: {}, num1: {}, num2: {}", o,n1,n2);
        OperationStrategy s= StrategyFactory.getStrategy(o,n1,n2);
        if(s==null){
            throw new UnsupportedOperationException("Operation not supported"+o);
        }
        log.info("excuting strategy: {}",s.getClass().getSimpleName());
        return s.execute(n1,n2);
    }
}
