package com.example.Calculator.model;

import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CalculateResponse<T> implements Serializable {
    private String message;
    private String code;
    private T data;
}
