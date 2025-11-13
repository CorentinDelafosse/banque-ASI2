package com.banque.dataTransferObjects;

public class TypeProduitDto {
    private float coutGestion;
    private float autorisationCarte;
    private float tauxInteretsAgios;
    private float cotisationCarte;
    private String intitule;
    private String code;

    public TypeProduitDto() {}
    public TypeProduitDto(float coutGestion, float autorisationCarte, String intitule, float cotisationCarte) {
        this.coutGestion = coutGestion;
        this.autorisationCarte = autorisationCarte;
        this.intitule = intitule;
        this.cotisationCarte = cotisationCarte;
    }

    public float getCoutGestion() { return coutGestion; }
    public float getAutorisationCarte() { return autorisationCarte; }
    public float getTauxInteretsAgios() { return tauxInteretsAgios; }
    public float getCotisationCarte() { return cotisationCarte; }
    public String getIntitule() { return intitule; }
    public String getCode() { return code; }

    public void setCoutGestion(float coutGestion) { this.coutGestion = coutGestion; }
    public void setAutorisationCarte(float autorisationCarte) { this.autorisationCarte = autorisationCarte; }
    public void setTauxInteretsAgios(float tauxInteretsAgios) { this.tauxInteretsAgios = tauxInteretsAgios; }
    public void setCotisationCarte(float cotisationCarte) { this.cotisationCarte = cotisationCarte; }
    public void setIntitule(String intitule) { this.intitule = intitule; }
    public void setCode(String code) { this.code = code; }

    @Override public String toString() { return intitule + " [" + code + "]"; }
    @Override public int hashCode() { return (code == null ? 0 : code.hashCode()); }
    @Override public boolean equals(Object o) {
        if (this == o) return true; if (!(o instanceof TypeProduitDto t)) return false;
        return (code == null ? t.code == null : code.equals(t.code));
    }
}