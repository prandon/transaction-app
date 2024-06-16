package com.pismo.transactions_app.config;

import com.pismo.transactions_app.constant.Constant;
import com.pismo.transactions_app.model.OperationType;
import com.pismo.transactions_app.repository.OperationTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Initializer implements CommandLineRunner {

  
    @Autowired
    OperationTypeRepository operationTypeRepository;

    @Override
    public void run(String... args) {
        OperationType operationType1 = OperationType.builder().id(1).description(Constant.NORMAL_PURCHASE).build();
        OperationType operationType2 = OperationType.builder().id(2).description(Constant.PURCHASE_WITH_INSTALLMENTS).build();
        OperationType operationType3 = OperationType.builder().id(3).description(Constant.WITHDRAWAL).build();
        OperationType operationType4 = OperationType.builder().id(4).description(Constant.CREDIT_VOUCHER).build();
        List<OperationType> operationTypes = List.of(operationType1, operationType2, operationType3, operationType4);
        operationTypeRepository.saveAll(operationTypes);
    }
}