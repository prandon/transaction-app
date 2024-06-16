package com.pismo.transactions_app.repository;

import com.pismo.transactions_app.model.OperationType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OperationTypeRepository extends JpaRepository<OperationType, Integer> {
    Optional<OperationType> findById(Integer id);
}
