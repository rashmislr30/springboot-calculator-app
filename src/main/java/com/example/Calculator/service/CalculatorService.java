package com.example.Calculator.service;

import com.example.Calculator.domain.Calculator;
import com.example.Calculator.domain.ChainedCalculator;
import com.example.Calculator.exception.CalculationException;
import com.example.Calculator.model.CalculateRequest;
import com.example.Calculator.model.ChainRequest;
import com.example.Calculator.model.Operation;
import com.example.Calculator.model.OperationRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Slf4j
public class CalculatorService {
    private final Calculator calculator;
    private final ChainedCalculator chainedCalculator;
    private final ValidationService validationService;

    @Autowired
    public CalculatorService(Calculator calculator, ValidationService validationService, ChainedCalculator chainedCalculator){
          this.calculator=calculator;
          this.validationService=validationService;
          this.chainedCalculator=chainedCalculator;
    }
    public Number calculate(CalculateRequest request){
        validationService.validateCalculateRequest(request);
        Operation op = validationService.validateParseOperation(request.getOperation());
        Number result;
        Number num1=null;
        Number num2=null;
        try{
            num1=request.getNum1();
            num2=request.getNum2();
            result=calculator.calculate(op,num1,num2);
        }
        catch(Exception e){
            log.error("CalculatorService: Error during calculate: Operation={}, num1={}, num2={}",op,num1,num2,e);
            throw new CalculationException("Failed to execute calculation",e);
        }
        if(result==null){
            log.error("CalculatorService: Error during calculate: Operation={}, num1={}, num2={}",op,num1,num2);
            throw new CalculationException("Failed to execute calculation");
        }
        return result;
    }
   public Number chain(ChainRequest chr){
       validationService.validateChainRequest(chr);
       Number initialValue=null;
       List<OperationRequest>ops=null;
       try{
           initialValue=chr.getInitialValue()!=null?chr.getInitialValue():0;
           ops=chr.getOperations();
           chainedCalculator.start(initialValue);
           for(OperationRequest or:ops){
                Operation o=validationService.validateParseOperation(or.getOp());
               chainedCalculator.apply(o,or.getNum());
           }
           return chainedCalculator.getResult();
       }
       catch(Exception e){
           log.error("CalculatorService: Error during calculateChain: initialValue={}, operations={}",initialValue,ops,e);
           throw new CalculationException("Failed to execute chained calculation",e);
       }
    }
}
