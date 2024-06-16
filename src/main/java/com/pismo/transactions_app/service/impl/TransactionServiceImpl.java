package com.pismo.transactions_app.service.impl;

import com.pismo.transactions_app.constant.Constant;
import com.pismo.transactions_app.dto.TransactionDto;
import com.pismo.transactions_app.dto.TransactionRequest;
import com.pismo.transactions_app.exception.ResourceNotFoundException;
import com.pismo.transactions_app.model.Account;
import com.pismo.transactions_app.model.OperationType;
import com.pismo.transactions_app.model.Transaction;
import com.pismo.transactions_app.repository.TransactionRepository;
import com.pismo.transactions_app.service.AccountService;
import com.pismo.transactions_app.service.OperationTypeService;
import com.pismo.transactions_app.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private AccountService accountService;
    @Autowired
    private OperationTypeService operationTypeService;

    @Override
    public TransactionDto createTransaction(TransactionRequest transactionRequest) throws ResourceNotFoundException {
        Account account = accountService.getAccount(transactionRequest.getAccountId());
        OperationType operationType = operationTypeService.getOperationType(transactionRequest.getOperationTypeId());

        Transaction transaction = Transaction.builder()
                .account(account).operationType(operationType).amount(transactionRequest.getAmount()).build();

        if (operationType.getDescription().equals(Constant.CREDIT_VOUCHER)) {
            return new TransactionDto(transactionRepository.save(transaction));
        }
        transaction.setAmount(transaction.getAmount().negate());
        return new TransactionDto(transactionRepository.save(transaction));
    }
}
