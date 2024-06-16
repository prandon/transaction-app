package com.pismo.transactions_app.service.impl;

import com.pismo.transactions_app.dto.TransactionDto;
import com.pismo.transactions_app.dto.TransactionRequest;
import com.pismo.transactions_app.exception.ResourceNotFoundException;
import com.pismo.transactions_app.model.Account;
import com.pismo.transactions_app.model.OperationType;
import com.pismo.transactions_app.model.Transaction;
import com.pismo.transactions_app.repository.TransactionRepository;
import com.pismo.transactions_app.service.AccountService;
import com.pismo.transactions_app.service.OperationTypeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TransactionServiceImplTest {
    @InjectMocks
    private TransactionServiceImpl transactionService;

    @Mock
    private TransactionRepository transactionRepository;

    @Mock
    private AccountService accountService;

    @Mock
    private OperationTypeService operationTypeService;

    @Test
    void createTransactionShouldCreateTransaction() throws ResourceNotFoundException {
        TransactionRequest transactionRequest = TransactionRequest.builder()
                .accountId(1).operationTypeId(4).amount(BigDecimal.TEN).build();
        Account account = Account.builder()
                .id(transactionRequest.getAccountId()).documentNumber(12312L).build();
        OperationType operationType = OperationType.builder()
                .id(transactionRequest.getOperationTypeId()).description("Credit Voucher").build();
        Transaction transaction = Transaction.builder()
                .account(account).operationType(operationType).amount(BigDecimal.TEN).build();
        when(transactionRepository.save(any()))
                .thenReturn(Transaction.builder().id(1).account(account).operationType(operationType).build());
        when(operationTypeService.getOperationType(4)).thenReturn(operationType);
        when(accountService.getAccount(1)).thenReturn(account);

        TransactionDto actual = transactionService.createTransaction(transactionRequest);
        verify(transactionRepository, times(1)).save(transaction);
        assertNotNull(actual);
        assertEquals(1, actual.getId());
    }

    @Test
    void createTransactionForCreditOperationShouldAddPositiveValue() throws ResourceNotFoundException {
        TransactionRequest transactionRequest = TransactionRequest.builder()
                .accountId(1).operationTypeId(4).amount(BigDecimal.valueOf(50)).build();
        Account account = Account.builder().id(1).documentNumber(12312L).build();
        OperationType operationType = OperationType.builder().id(4).description("Credit Voucher").build();
        Transaction transaction = Transaction.builder().account(account).operationType(operationType).amount(BigDecimal.valueOf(50)).build();
        when(transactionRepository.save(any()))
                .thenReturn(Transaction.builder().id(1).account(account).operationType(operationType).build());
        when(operationTypeService.getOperationType(4)).thenReturn(operationType);
        when(accountService.getAccount(1)).thenReturn(account);

        TransactionDto actual = transactionService.createTransaction(transactionRequest);
        verify(transactionRepository, times(1)).save(transaction);
        assertNotNull(actual);
        assertEquals(1, actual.getId());
    }

    @Test
    void createTransactionForPurchaseOperationShouldAddNegativeValue() throws ResourceNotFoundException {
        TransactionRequest transactionRequest = TransactionRequest.builder()
                .accountId(1).operationTypeId(4).amount(BigDecimal.valueOf(50)).build();
        Account account = Account.builder().id(1).documentNumber(12312L).build();
        OperationType operationType = OperationType.builder().id(1).description("Normal Purchase").build();
        ArgumentCaptor<Transaction> transactionArgumentCaptor = ArgumentCaptor.forClass(Transaction.class);
        when(transactionRepository.save(any()))
                .thenReturn(Transaction.builder().id(1).account(account).operationType(operationType).build());
        when(operationTypeService.getOperationType(4)).thenReturn(operationType);
        when(accountService.getAccount(1)).thenReturn(account);

        TransactionDto actual = transactionService.createTransaction(transactionRequest);

        verify(transactionRepository, times(1)).save(transactionArgumentCaptor.capture());
        Transaction savedTransaction = transactionArgumentCaptor.getValue();
        assertNotNull(actual);
        assertEquals(1, actual.getId());
        assertEquals(BigDecimal.valueOf(-50), savedTransaction.getAmount());
    }
}