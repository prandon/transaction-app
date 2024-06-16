package com.pismo.transactions_app.dto;

import lombok.Data;

@Data
public class ExceptionResponse {
    private final String errorCode;
    private final String message;
}
