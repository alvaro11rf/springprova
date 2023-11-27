package com.esliceu.testspring.Services;

import com.esliceu.testspring.Dto.OperationDTO;
import com.esliceu.testspring.Entities.Operation;
import com.esliceu.testspring.Repos.OperationRepo;
import com.esliceu.testspring.Repos.OperationRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OperationService {
    @Autowired
    OperationRepo operationRepo;

    public Operation newOperation(int n1, int n2, String top) {
        Operation.TOp operationType = getOperationType(top);
        Operation operation = new Operation();
        operation.setN1(n1);
        operation.setN2(n2);
        operation.setOpType(operationType);
        OperationRepo.save(operation);
        return operation;
    }

    private Operation.TOp getOperationType(String top) {
        if (top.equals("+")) return Operation.TOp.SUM;
        if (top.equals("-")) return Operation.TOp.SUB;
        if (top.equals("x")) return Operation.TOp.MULT;
        if (top.equals("/")) return Operation.TOp.DIV;
return null;
    }

    public List<OperationDTO> findallOperations() {
        return operationRepo.findAll().stream().map(o -> new OperationDTO(o)).collect(Collectors.toList());
    }
}
