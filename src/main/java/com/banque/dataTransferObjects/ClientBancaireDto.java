package com.banque.dataTransferObjects;

import java.util.LinkedHashSet;
import java.util.Set;

public class ClientBancaireDto {
    private Set<PersonneDto> personnesDtos = new LinkedHashSet<>();

    public ClientBancaireDto() {}
    public ClientBancaireDto(Set<PersonneDto> personnesDtos) { this.personnesDtos = personnesDtos; }

    public Set<PersonneDto> getPersonnesDtos() { return personnesDtos; }
    public void setPersonnesDtos(Set<PersonneDto> personnesDtos) { this.personnesDtos = personnesDtos; }

    public void addPersonneDto(PersonneDto p) { this.personnesDtos.add(p); }
    public void removePersonneDto(PersonneDto p) { this.personnesDtos.remove(p); }
}