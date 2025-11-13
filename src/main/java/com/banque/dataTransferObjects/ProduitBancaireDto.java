package com.banque.dataTransferObjects;

import java.util.LinkedHashSet;
import java.util.Set;

public class ProduitBancaireDto {
    private String numeroCompte;
    private float soldeCourant;
    private TypeProduitDto typeProduitDto;
    private ClientBancaireDto clientBancaireDto;
    private Set<OperationDto> operationDtos = new LinkedHashSet<>();

    public ProduitBancaireDto() {}
    public ProduitBancaireDto(String numeroCompte, float soldeCourant,
                              TypeProduitDto typeProduitDto, ClientBancaireDto clientBancaireDto) {
        this.numeroCompte = numeroCompte;
        this.soldeCourant = soldeCourant;
        this.typeProduitDto = typeProduitDto;
        this.clientBancaireDto = clientBancaireDto;
    }

    public String getNumeroCompte() { return numeroCompte; }
    public float getSoldeCourant() { return soldeCourant; }
    public TypeProduitDto getTypeProduitDto() { return typeProduitDto; }
    public ClientBancaireDto getClientBancaireDto() { return clientBancaireDto; }
    public Set<OperationDto> getOperationDtos() { return operationDtos; }

    public void setNumeroCompte(String numeroCompte) { this.numeroCompte = numeroCompte; }
    public void setSoldeCourant(float soldeCourant) { this.soldeCourant = soldeCourant; }
    public void setTypeProduitDto(TypeProduitDto typeProduitDto) { this.typeProduitDto = typeProduitDto; }
    public void setClientBancaireDto(ClientBancaireDto clientBancaireDto) { this.clientBancaireDto = clientBancaireDto; }
    public void setOperationDtos(Set<OperationDto> operationDtos) { this.operationDtos = operationDtos; }
}