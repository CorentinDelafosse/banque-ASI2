package com.banque.service;

import com.banque.model.PersonnePhysique;

import java.util.List;

public interface PersonnePhysiqueService {
    public List<PersonnePhysique> getAllPersonnePhysique();
    public PersonnePhysique createPersonnePhysique(PersonnePhysique PersonnePhysique);
    public PersonnePhysique getPersonnePhysiqueById(Long id);
    public PersonnePhysique updatePersonnePhysique(PersonnePhysique PersonnePhysique);
    public void deletePersonnePhysiqueById(Long id);
}
