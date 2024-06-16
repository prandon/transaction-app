package com.pismo.transactions_app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "operation_type")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OperationType {
    @Id
    private Integer id;
    private String description;
}
