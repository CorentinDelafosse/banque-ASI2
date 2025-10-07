package com.banque.service;

import com.banque.model.PersonneMorale;

import java.util.List;

public interface PersonneMoraleService {
    public List<PersonneMorale> getAllPersonneMorale();
    public PersonneMorale createPersonneMorale(PersonneMorale PersonneMorale);
    public PersonneMorale getPersonneMoraleById(Long id);
    public PersonneMorale updatePersonneMorale(PersonneMorale PersonneMorale);
    public void deletePersonneMoraleById(Long id);
}
