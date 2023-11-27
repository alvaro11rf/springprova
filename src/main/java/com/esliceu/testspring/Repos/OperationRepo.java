package com.esliceu.testspring.Repos;

import com.esliceu.testspring.Entities.Operation;

import java.util.List;

public interface OperationRepo {
    static void save(Operation operation) {
    }

    List<Operation> findAll();
}
