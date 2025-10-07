package com.banque.service;

import com.banque.model.Operation;

import java.util.List;

public interface OperationService {
    public List<Operation> getAllOperation();
    public Operation createOperation(Operation Operation);
    public Operation getOperationById(Long id);
    public Operation updateOperation(Operation Operation);
    public void deleteOperationById(Long id);
}
