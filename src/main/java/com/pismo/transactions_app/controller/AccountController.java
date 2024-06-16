package com.pismo.transactions_app.controller;

import com.pismo.transactions_app.dto.AccountRequest;
import com.pismo.transactions_app.model.Account;
import com.pismo.transactions_app.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping("/{accountId}")
    public ResponseEntity<Account> getAccount(@PathVariable("accountId") Integer accountId) throws Exception {
        Account account = accountService.getAccount(accountId);
        return ResponseEntity.ok(account);
    }

    @PostMapping(value = "/", consumes = "application/json")
    public ResponseEntity<Account> createAccount(@RequestBody AccountRequest accountRequest) {
        Account savedAccount = accountService.createAccount(Account.builder().documentNumber(accountRequest.getDocumentNumber())
                .build());
        return ResponseEntity.ok(savedAccount);
    }
}
