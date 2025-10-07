package com.banque.model;

import jakarta.persistence.*;

@Entity(name = "PersonneMorale")
@Table(name = "personne_morale")
public class PersonneMorale extends Personne {

    @Column(name = "siret", nullable = true, columnDefinition = "TEXT")
    private String SIRET;
    @Column(name = "raison_sociale", nullable = false, columnDefinition = "TEXT")
    private String raisonSociale;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "type_personne_morale")
    private TypePersonneMorale typePersonneMorale;

    public PersonneMorale() {}

    public PersonneMorale(String adresse, String SIRET, String raisonSociale, TypePersonneMorale typePersonneMorale) {
        super(adresse);
        this.SIRET = SIRET;
        this.raisonSociale = raisonSociale;
        this.typePersonneMorale = typePersonneMorale;
        typePersonneMorale.getPersonnesMorale().add(this);
    }

    public String getSIRET() {
        return SIRET;
    }

    public void setSIRET(String SIRET) {
        this.SIRET = SIRET;
    }

    public String getRaisonSociale() {
        return raisonSociale;
    }

    public void setRaisonSociale(String raisonSociale) {
        this.raisonSociale = raisonSociale;
    }

    public TypePersonneMorale getTypePersonneMorale() {
        return typePersonneMorale;
    }

    public void setTypePersonneMorale(TypePersonneMorale typePersonneMorale) {
        this.typePersonneMorale = typePersonneMorale;
    }

    @Override
    public String toString() {
        return "\nPersonneMorale{" +
                "\nid=" + id +
                ", \nSIRET='" + SIRET + '\'' +
                ", \nraisonSociale='" + raisonSociale + '\'' +
                ", \nadresse='" + adresse + '\'' +
                "}\n";
    }

    public String nomComplet() {
        return raisonSociale;
    }

    @PreRemove
    private void gererLien(){
        if(typePersonneMorale != null){
            typePersonneMorale.getPersonnesMorale().remove(this);
        }
        typePersonneMorale = null;
    }
}
