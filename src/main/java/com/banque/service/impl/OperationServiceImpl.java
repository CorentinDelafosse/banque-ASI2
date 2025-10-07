package com.banque.service.impl;

import com.banque.model.Operation;
import com.banque.repository.OperationRepository;
import com.banque.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperationServiceImpl implements OperationService {
    private OperationRepository OperationRepository;

    @Autowired
    public OperationServiceImpl(OperationRepository OperationRepository) {
        this.OperationRepository = OperationRepository;
    }

    @Override
    public List<Operation> getAllOperation()
    {
        return OperationRepository.findAll();
    }

    @Override
    public Operation createOperation(Operation Operation)
    {
        return OperationRepository.save(Operation);
    }

    @Override
    public Operation getOperationById(Long id)
    {
        return OperationRepository.findById(id).orElseThrow();
    }

    @Override
    public Operation updateOperation(Operation Operation)
    {
        return OperationRepository.save(Operation);
    }

    @Override
    public void deleteOperationById(Long id)
    {
        OperationRepository.findById(id).orElseThrow();
        OperationRepository.deleteById(id);
    }
}
