package com.example.Calculator.exception;

import lombok.Data;
@Data
public class BadParameterException extends RuntimeException{
        public BadParameterException(String msg){
            super(msg);
        }
        public BadParameterException(String msg,Throwable cause){
            super(msg,cause);
        }
        public BadParameterException(Throwable cause) {
            super(cause);
        }
}
