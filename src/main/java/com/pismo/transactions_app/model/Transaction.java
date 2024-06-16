package com.pismo.transactions_app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "transaction")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "accountId", nullable = false)
    @JsonIgnore
    private Account account;

    @ManyToOne
    @JoinColumn(name = "operationTypeId", nullable = false)
    private OperationType operationType;

    private BigDecimal amount;

    @Column(name = "eventDate", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime eventDate;
}
