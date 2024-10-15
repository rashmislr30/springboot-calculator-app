package com.example.Calculator.exception;

import com.example.Calculator.model.CalculateResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(BadParameterException.class)
    public ResponseEntity<CalculateResponse<String>> handleBadParameterException(BadParameterException ex){
        CalculateResponse<String> response=new CalculateResponse<>(HttpStatus.BAD_REQUEST.toString(),ex.getMessage(),null);
        return new ResponseEntity<>(response,HttpStatus.BAD_GATEWAY);
    }
    @ExceptionHandler(CalculationException.class)
    public ResponseEntity<CalculateResponse<String>> handleCalculationException(CalculationException ex){
        if(ex.getCause() instanceof ArithmeticException){
            return handleArithmeticException(ex.getCause());
        }
        CalculateResponse<String>res=new CalculateResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.toString(),ex.getMessage(),null);
        return new ResponseEntity<>(res,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<CalculateResponse<String>> handleGeneralException(Exception ex){
        String msg=ex.getMessage()!=null?ex.getMessage():"error occured";
        CalculateResponse<String>res=new CalculateResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.toString(),msg,null);
        return new ResponseEntity<>(res,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<CalculateResponse<String>> handleArithmeticException(Throwable t){
        String msg=t.getMessage()!=null?t.getMessage():"arithmatic error";
        CalculateResponse<String>res=new CalculateResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.toString(),msg,null);
        return new ResponseEntity<>(res,HttpStatus.BAD_REQUEST);
    }
}
