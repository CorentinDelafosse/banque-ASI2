package com.banque.dataTransferObjects;

public class PersonneDto {
    private String typePersonne;
    private String adresse;
    private String nom;

    public PersonneDto() {}
    public PersonneDto(String typePersonne, String adresse, String nom) {
        this.typePersonne = typePersonne;
        this.adresse = adresse;
        this.nom = nom;
    }

    public String getTypePersonne() { return typePersonne; }
    public String getAdresse() { return adresse; }
    public String getNom() { return nom; }

    public void setTypePersonne(String typePersonne) { this.typePersonne = typePersonne; }
    public void setAdresse(String adresse) { this.adresse = adresse; }
    public void setNom(String nom) { this.nom = nom; }

    @Override public String toString() { return nom + " (" + typePersonne + ")"; }
    @Override public int hashCode() { return (nom == null ? 0 : nom.hashCode()); }
    @Override public boolean equals(Object o) {
        if (this == o) return true; if (!(o instanceof PersonneDto p)) return false;
        return (nom == null ? p.nom == null : nom.equals(p.nom))
                && (typePersonne == null ? p.typePersonne == null : typePersonne.equals(p.typePersonne))
                && (adresse == null ? p.adresse == null : adresse.equals(p.adresse));
    }
}