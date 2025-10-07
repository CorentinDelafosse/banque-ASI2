package com.banque.model;

import jakarta.persistence.*;
import jdk.jfr.Name;

import java.sql.Date;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity(name = "operation")
@Table(name = "operation")
public class Operation {
    @Id
    @SequenceGenerator(name = "operation_sequence", sequenceName = "operation_sequence", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "operation_sequence")
    @Column(name = "id", nullable = false)
    protected Long id;

    @Column(name = "date_operation", nullable = true, columnDefinition = "DATE")
    private Date dateOperation;

    @Column(name = "montant", nullable = true, columnDefinition = "FLOAT")
    private float montant;

    @Column(name = "type", nullable = true, columnDefinition = "TEXT")
    private String type;

    @Column(name = "libelle", nullable = true, columnDefinition = "TEXT")
    private String libelle;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "produitbancaire_id")
    private ProduitBancaire produitBancaire;

    public Operation(float montant, String type, String libelle) {
        this.dateOperation = new Date(System.currentTimeMillis()) ;
        this.montant = montant;
        this.type = type;
        this.libelle = libelle;
    }

    public Operation() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateOperation() {
        return dateOperation;
    }

    public void setDateOperation(Date dateOperation) {
        this.dateOperation = dateOperation;
    }

    public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public ProduitBancaire getProduitBancaire() {
        return produitBancaire;
    }

    public void setProduitBancaire(ProduitBancaire produitBancaire) {
        this.produitBancaire = produitBancaire;
    }

    public void addProduitBancaire(ProduitBancaire pb) {
        this.produitBancaire = pb;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "id=" + id +
                ", dateOperation=" + dateOperation +
                ", montant=" + montant +
                ", type='" + type + '\'' +
                ", libelle='" + libelle + '\'' +
                ", produitBancaire=" + produitBancaire +
                '}';
    }

    @PreRemove
    private void gererLien(){
        if(produitBancaire != null){
            produitBancaire.getOperations().remove(this);
        }
        produitBancaire = null;
    }
}