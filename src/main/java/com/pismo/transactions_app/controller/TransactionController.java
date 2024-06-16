package com.pismo.transactions_app.controller;

import com.pismo.transactions_app.dto.TransactionDto;
import com.pismo.transactions_app.dto.TransactionRequest;
import com.pismo.transactions_app.exception.ResourceNotFoundException;
import com.pismo.transactions_app.model.Transaction;
import com.pismo.transactions_app.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @PostMapping("/")
    public ResponseEntity<TransactionDto> createTransaction(@RequestBody TransactionRequest transactionRequest) throws ResourceNotFoundException {
        TransactionDto transaction = transactionService.createTransaction(transactionRequest);
        return ResponseEntity.ok(transaction);
    }
}
