package com.banque.mapper;

import com.banque.dataTransferObjects.ClientBancaireDto;
import com.banque.dataTransferObjects.PersonneDto;
import com.banque.model.ClientBancaire;
import com.banque.model.Personne;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;

public class ClientBancaireMapper {

    public static ClientBancaireDto toDTO(ClientBancaire e) {
        if (e == null) return null;
        ClientBancaireDto d = new ClientBancaireDto();
        if (e.getPersonnes() != null) {
            d.setPersonnesDtos(
                    e.getPersonnes().stream()
                            .map(PersonneMapper::toDTO)
                            .collect(Collectors.toCollection(LinkedHashSet::new))
            );
        }
        return d;
    }

    public static ClientBancaire toEntity(ClientBancaireDto d) {
        if (d == null) return null;
        ClientBancaire e = new ClientBancaire();
        if (d.getPersonnesDtos() != null) {
            e.setPersonnes(
                    new ArrayList<>(
                            d.getPersonnesDtos().stream()
                                    .map(PersonneMapper::toEntity)
                                    .collect(Collectors.toCollection(LinkedHashSet::new))
                    )
            );
            // cohérence bidirectionnelle
            for (Personne p : e.getPersonnes()) {
                if (!p.getClientsBancaires().contains(e)) {
                    p.getClientsBancaires().add(e);
                }
            }
        }
        return e;
    }
}