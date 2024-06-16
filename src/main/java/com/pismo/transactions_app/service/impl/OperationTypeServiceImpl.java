package com.pismo.transactions_app.service.impl;

import com.pismo.transactions_app.exception.ResourceNotFoundException;
import com.pismo.transactions_app.model.OperationType;
import com.pismo.transactions_app.repository.OperationTypeRepository;
import com.pismo.transactions_app.service.OperationTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OperationTypeServiceImpl implements OperationTypeService {
    @Autowired
    private OperationTypeRepository operationTypeRepository;

    @Override
    public OperationType getOperationType(Integer operationId) throws ResourceNotFoundException {
        Optional<OperationType> operationTypeOptional = operationTypeRepository.findById(operationId);
        return operationTypeOptional.orElseThrow(() -> new ResourceNotFoundException("OperationType not found for id: "+ operationId));
    }
}
