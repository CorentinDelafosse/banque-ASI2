package com.banque.dataTransferObjects;

import java.sql.Date;

public class OperationDto {
    private Long idOperation;
    private String intituleOperation;
    private float montant;
    private String typeOperation;
    private Date dateOperation;

    public OperationDto() {}
    public OperationDto(String intituleOperation, float montant, String typeOperation, Date dateOperation) {
        this.intituleOperation = intituleOperation;
        this.montant = montant;
        this.typeOperation = typeOperation;
        this.dateOperation = dateOperation;
    }

    public Long getIdOperation() { return idOperation; }
    public String getIntituleOperation() { return intituleOperation; }
    public float getMontant() { return montant; }
    public String getTypeOperation() { return typeOperation; }
    public Date getDateOperation() { return dateOperation; }

    public void setIdOperation(Long idOperation) { this.idOperation = idOperation; }
    public void setIntituleOperation(String intituleOperation) { this.intituleOperation = intituleOperation; }
    public void setMontant(float montant) { this.montant = montant; }
    public void setTypeOperation(String typeOperation) { this.typeOperation = typeOperation; }
    public void setDateOperation(Date dateOperation) { this.dateOperation = dateOperation; }
}