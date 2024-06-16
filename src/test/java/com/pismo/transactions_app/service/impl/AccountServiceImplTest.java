package com.pismo.transactions_app.service.impl;

import com.pismo.transactions_app.model.Account;
import com.pismo.transactions_app.repository.AccountRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AccountServiceImplTest {
    @InjectMocks
    private AccountServiceImpl accountService;

    @Mock
    private AccountRepository accountRepository;

    @Test
    void getAccountByAccountIdShouldReturnAccount() throws Exception {
        when(accountRepository.findById(any()))
                .thenReturn(Optional.of(Account.builder().id(10).documentNumber(80808080L).build()));

        Account actual = accountService.getAccount(10);

        assertEquals(10, actual.getId());
        assertEquals(80808080L, actual.getDocumentNumber());
    }

    @Test
    void getAccountByAccountIdShouldThrowResourceNotFoundExceptionIfAccountNotFound() {
        assertThrows(Exception.class, () -> accountService.getAccount(10));
    }

    @Test
    void createAccountShouldCreateAccount() {
        Account account = Account.builder().build();
        when(accountRepository.save(any())).thenReturn(Account.builder().id(1).build());

        Account actual = accountService.createAccount(account);
        assertEquals(1, actual.getId());
    }
}
