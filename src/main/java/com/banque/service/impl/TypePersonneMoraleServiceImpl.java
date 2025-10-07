package com.banque.service.impl;

import com.banque.model.TypePersonneMorale;
import com.banque.repository.TypePersonneMoraleRepository;
import com.banque.service.TypePersonneMoraleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypePersonneMoraleServiceImpl implements TypePersonneMoraleService {
    private TypePersonneMoraleRepository TypePersonneMoraleRepository;

    @Autowired
    public TypePersonneMoraleServiceImpl(TypePersonneMoraleRepository TypePersonneMoraleRepository) {
        this.TypePersonneMoraleRepository = TypePersonneMoraleRepository;
    }

    @Override
    public List<TypePersonneMorale> getAllTypePersonneMorale()
    {
        return TypePersonneMoraleRepository.findAll();
    }

    @Override
    public TypePersonneMorale createTypePersonneMorale(TypePersonneMorale TypePersonneMorale)
    {
        return TypePersonneMoraleRepository.save(TypePersonneMorale);
    }

    @Override
    public TypePersonneMorale getTypePersonneMoraleById(Long id)
    {
        return TypePersonneMoraleRepository.findById(id).orElseThrow();
    }

    @Override
    public TypePersonneMorale updateTypePersonneMorale(TypePersonneMorale TypePersonneMorale)
    {
        return TypePersonneMoraleRepository.save(TypePersonneMorale);
    }

    @Override
    public void deleteTypePersonneMoraleById(Long id)
    {
        TypePersonneMoraleRepository.findById(id).orElseThrow();
        TypePersonneMoraleRepository.deleteById(id);
    }
}
