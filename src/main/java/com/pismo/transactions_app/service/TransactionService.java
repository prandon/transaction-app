package com.pismo.transactions_app.service;

import com.pismo.transactions_app.dto.TransactionDto;
import com.pismo.transactions_app.dto.TransactionRequest;
import com.pismo.transactions_app.exception.ResourceNotFoundException;
import com.pismo.transactions_app.model.Transaction;

public interface TransactionService {

    TransactionDto createTransaction(TransactionRequest transactionRequest) throws ResourceNotFoundException;
}
