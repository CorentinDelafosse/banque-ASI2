package com.banque.service;

import com.banque.model.TypePersonneMorale;

import java.util.List;

public interface TypePersonneMoraleService {
    public List<TypePersonneMorale> getAllTypePersonneMorale();
    public TypePersonneMorale createTypePersonneMorale(TypePersonneMorale TypePersonneMorale);
    public TypePersonneMorale getTypePersonneMoraleById(Long id);
    public TypePersonneMorale updateTypePersonneMorale(TypePersonneMorale TypePersonneMorale);
    public void deleteTypePersonneMoraleById(Long id);
}
