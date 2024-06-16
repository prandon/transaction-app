package com.pismo.transactions_app.service;

import com.pismo.transactions_app.exception.ResourceNotFoundException;
import com.pismo.transactions_app.model.OperationType;

public interface OperationTypeService {
    OperationType getOperationType(Integer id) throws ResourceNotFoundException;
}
