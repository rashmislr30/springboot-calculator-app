package com.example.Calculator.strategy;

import com.example.Calculator.model.Operation;
import com.example.Calculator.strategy.add.DoubleAddOperation;
import com.example.Calculator.strategy.add.IntegerAddOperation;
import com.example.Calculator.strategy.add.LongAddOperation;
import com.example.Calculator.strategy.divide.DoubleDivOperation;
import com.example.Calculator.strategy.divide.IntegerDivOperation;
import com.example.Calculator.strategy.divide.LongDivOperation;
import com.example.Calculator.strategy.multiply.DoubleMulOperation;
import com.example.Calculator.strategy.multiply.IntegerMulOperation;
import com.example.Calculator.strategy.multiply.LongMulOperation;
import com.example.Calculator.strategy.subtract.DoubleSubOperation;
import com.example.Calculator.strategy.subtract.IntegerSubOperation;
import com.example.Calculator.strategy.subtract.LongSubOperation;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StrategyFactory {
    public static OperationStrategy getStrategy(Operation o, Number n1, Number n2){
        if(o==Operation.ADD){
            if(n1 instanceof Long || n2 instanceof Long){
                return new LongAddOperation();
            }
            else if(n1 instanceof Double || n2 instanceof Double){
                return new DoubleAddOperation();
            }
            else if(n1 instanceof Integer && n2 instanceof Integer){
                return new IntegerAddOperation();
            }
        }
        else if(o==Operation.SUBTRACT){
            if(n1 instanceof Long || n2 instanceof Long){
                return new LongSubOperation();
            }
            else if(n1 instanceof Double || n2 instanceof Double){
                return new DoubleSubOperation();
            }
            else if(n1 instanceof Integer && n2 instanceof Integer){
                return new IntegerSubOperation();
            }
        }
        else if(o==Operation.MULTIPLY){
            if(n1 instanceof Long || n2 instanceof Long){
                return new LongMulOperation();
            }
            else if(n1 instanceof Double || n2 instanceof Double){
                return new DoubleMulOperation();
            }
            else if(n1 instanceof Integer && n2 instanceof Integer){
                return new IntegerMulOperation();
            }
        }
        else if(o==Operation.DIVIDE){
            if(n1 instanceof Long || n2 instanceof Long){
                return new LongDivOperation();
            }
            else if(n1 instanceof Double || n2 instanceof Double){
                return new DoubleDivOperation();
            }
            else if(n1 instanceof Integer && n2 instanceof Integer){
                return new IntegerDivOperation();
            }
        }
        log.info("Unsupported operation or number type, num1: {}, num2: {}", n1.getClass(), n2.getClass());
        throw new UnsupportedOperationException("Unsupported operation or number type");
    }
}
