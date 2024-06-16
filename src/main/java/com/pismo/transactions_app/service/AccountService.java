package com.pismo.transactions_app.service;

import com.pismo.transactions_app.exception.ResourceNotFoundException;
import com.pismo.transactions_app.model.Account;

public interface AccountService {
    Account getAccount(Integer accountId) throws ResourceNotFoundException;
    Account createAccount(Account account);
}
