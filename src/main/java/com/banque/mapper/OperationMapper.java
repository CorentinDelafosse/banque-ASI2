package com.banque.mapper;

import com.banque.dataTransferObjects.OperationDto;
import com.banque.model.Operation;

public class OperationMapper {

    public static OperationDto toDTO(Operation e) {
        if (e == null) return null;
        OperationDto d = new OperationDto();
        d.setIdOperation(e.getId());
        d.setIntituleOperation(e.getLibelle());   // libelle -> intituleOperation
        d.setMontant(e.getMontant());
        d.setTypeOperation(e.getType());          // type -> typeOperation
        d.setDateOperation(e.getDateOperation());
        return d;
    }

    public static Operation toEntity(OperationDto d) {
        if (d == null) return null;
        Operation e = new Operation();
        e.setId(d.getIdOperation());
        e.setLibelle(d.getIntituleOperation());
        e.setMontant(d.getMontant());
        e.setType(d.getTypeOperation());
        e.setDateOperation(d.getDateOperation());
        // NE PAS toucher à produitBancaire ici (résolu dans le service)
        return e;
    }
}