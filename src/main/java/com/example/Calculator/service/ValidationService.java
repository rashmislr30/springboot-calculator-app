package com.example.Calculator.service;

import com.example.Calculator.exception.BadParameterException;
import com.example.Calculator.model.CalculateRequest;
import com.example.Calculator.model.ChainRequest;
import com.example.Calculator.model.Operation;
import com.example.Calculator.model.OperationRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ValidationService {
    public void validateCalculateRequest(CalculateRequest cr){
        Operation op=validateParseOperation(cr.getOperation());
        Number n1=cr.getNum1();
        Number n2=cr.getNum2();
        validateOperation(op);
        validateInput(op,n1,n2);
    }
    public void validateOperation(Operation o){
        if(o==null){
            log.error("Invalid operation: operation cannot be null or operation not supported");
            throw new BadParameterException("Operation cannot be null/not supported");
        }
    }
    public void validateInput(Operation o, Number n1, Number n2){
        if(n1==null||n2==null){
            log.error("Invalid input: Numbers cannot be null");
            throw new BadParameterException("Invalid input: Numbers cannot be null");
        }
        if((o==Operation.DIVIDE && n2.doubleValue()==0.0)||(o==Operation.DIVIDE && n2.intValue()==0)||(o==Operation.DIVIDE && n2.longValue()==0)){
            log.error("Invalid input: Divisor cannot be 0");
            throw new BadParameterException("Invalid input: Divisor cannot be 0");
        }
    }
    public void validateChainRequest(ChainRequest chr){
        List<OperationRequest>ops=chr.getOperations();
        validateInput(ops);
    }
   public void validateInput(List<OperationRequest> ops){
        if(ops==null||ops.isEmpty()){
            log.error("Invalid operation list: Operation list cannot be null or empty");
            throw new BadParameterException("Operation list cannot be null or empty");
        }
        for(OperationRequest o:ops){
            validateParseOperation(o.getOp());
            if(o==null||o.getNum()==null){
                log.error("Invalid operation request: Operation and number cannot be null");
                throw new BadParameterException("Operation request/ number cannot be null");
            }
        }
    }
    public Operation validateParseOperation(String o){
        try{
            return Operation.valueOf(o.toUpperCase());
        }
        catch(IllegalArgumentException e){
            log.error("Invalid operation: " + o);
            throw new BadParameterException("Invalid operation: " + o+". Supported operations are: ADD, SUBTRACT, MULTIPLY, DIVIDE.");
        }
    }
}
