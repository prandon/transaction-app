package com.pismo.transactions_app.controller;

import com.pismo.transactions_app.TestUtil;
import com.pismo.transactions_app.dto.AccountRequest;
import com.pismo.transactions_app.dto.TransactionRequest;
import com.pismo.transactions_app.service.TransactionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.io.IOException;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(TransactionController.class)
class TransactionControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TransactionService transactionService;

    @Test
    void createTransactionShouldReturnOk() throws Exception {
        TransactionRequest transactionRequest = TransactionRequest.builder()
                .accountId(1).operationTypeId(1).amount(BigDecimal.TEN).build();
        mockMvc.perform(MockMvcRequestBuilders.post("/transactions/")
                .contentType(MediaType.APPLICATION_JSON).content(TestUtil.toJson(transactionRequest))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}