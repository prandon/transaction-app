package com.pismo.transactions_app.dto;

import com.pismo.transactions_app.model.Transaction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDto {
    private Integer id;
    private Integer accountId;
    private Integer operationTypeId;
    private BigDecimal amount;
    private LocalDateTime eventDate;

    public TransactionDto(Transaction transaction) {
        this.id = transaction.getId();
        this.amount = transaction.getAmount();
        this.accountId = transaction.getAccount().getId();
        this.operationTypeId = transaction.getOperationType().getId();
        this.eventDate = transaction.getEventDate();
    }
}
