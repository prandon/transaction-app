package com.pismo.transactions_app.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pismo.transactions_app.TestUtil;
import com.pismo.transactions_app.dto.AccountRequest;
import com.pismo.transactions_app.service.AccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.io.IOException;

@WebMvcTest(AccountController.class)
class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AccountService accountService;

    @Test
    void getAccountByAccountIdShouldReturnAccount() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/accounts/{accountId}", 1))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void createAccountShouldCreateAccount() throws Exception {
        AccountRequest accountRequest = new AccountRequest(123123L);
        mockMvc.perform(MockMvcRequestBuilders.post("/accounts/")
                .contentType(MediaType.APPLICATION_JSON).content(TestUtil.toJson(accountRequest))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}