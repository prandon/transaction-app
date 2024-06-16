package com.pismo.transactions_app.service.impl;

import com.pismo.transactions_app.constant.Constant;
import com.pismo.transactions_app.exception.ResourceNotFoundException;
import com.pismo.transactions_app.model.OperationType;
import com.pismo.transactions_app.repository.OperationTypeRepository;
import com.pismo.transactions_app.service.OperationTypeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OperationTypeServiceImplTest {
    @InjectMocks
    private OperationTypeServiceImpl operationTypeService;

    @Mock
    private OperationTypeRepository operationTypeRepository;

    @Test
    void getOperationTypeShouldReturnOperationTypeForId() throws ResourceNotFoundException {
        when(operationTypeRepository.findById(any()))
                .thenReturn(Optional.of(OperationType.builder().id(1).description(Constant.NORMAL_PURCHASE).build()));
        OperationType actual = operationTypeService.getOperationType(1);
        assertEquals(Constant.NORMAL_PURCHASE, actual.getDescription());
    }

    @Test
    void getOperationTypeShouldThrowResourceNotFoundExceptionIfNotFound() {
        assertThrows(ResourceNotFoundException.class, () -> operationTypeService.getOperationType(1));
    }
}