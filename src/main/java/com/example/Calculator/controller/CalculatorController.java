package com.example.Calculator.controller;

import com.example.Calculator.model.CalculateRequest;
import com.example.Calculator.model.CalculateResponse;
import com.example.Calculator.model.ChainRequest;
import com.example.Calculator.service.CalculatorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/calculator")
@Slf4j
public class CalculatorController {

    private final CalculatorService calculatorService;
    @Autowired
    public CalculatorController(CalculatorService calculatorService){
        this.calculatorService=calculatorService;
    }

    @PostMapping("/calculate")
    public CalculateResponse calculateOperation(@RequestBody CalculateRequest request){
        log.info("CalculatorController: received calculate request: {}",request);
        Number result= calculatorService.calculate(request);
        return CalculateResponse.builder().code("200").message("calculator calculation successful").data(result).build();
    }

    @PostMapping("/chain")
    public CalculateResponse chainOperation(@RequestBody ChainRequest request){
        log.info("CalculatorController: received chain request: {}",request);
        Number result=calculatorService.chain(request);
        return CalculateResponse.builder().code("200").message("chain calculation successful").data(result).build();
    }
}
