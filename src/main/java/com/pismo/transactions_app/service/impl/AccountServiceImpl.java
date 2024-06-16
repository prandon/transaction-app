package com.pismo.transactions_app.service.impl;

import com.pismo.transactions_app.exception.ResourceNotFoundException;
import com.pismo.transactions_app.model.Account;
import com.pismo.transactions_app.repository.AccountRepository;
import com.pismo.transactions_app.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account getAccount(Integer accountId) throws ResourceNotFoundException {
        Optional<Account> accountOptional = accountRepository.findById(accountId);

        return accountOptional.orElseThrow(() -> new ResourceNotFoundException("Account not found for accountId: "+ accountId));
    }

    @Override
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }
}
