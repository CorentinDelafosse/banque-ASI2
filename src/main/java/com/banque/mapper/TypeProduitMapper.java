package com.banque.mapper;

import com.banque.dataTransferObjects.TypeProduitDto;
import com.banque.model.TypeProduit;

public class TypeProduitMapper {

    public static TypeProduitDto toDTO(TypeProduit e) {
        if (e == null) return null;
        TypeProduitDto d = new TypeProduitDto();
        // Le modèle ne possède pas coutGestion / autorisationCarte / code
        d.setCoutGestion(0f);
        d.setAutorisationCarte(0f);
        d.setCode(null);

        d.setIntitule(e.getIntitule());
        d.setCotisationCarte(e.getCotisationCarte());
        d.setTauxInteretsAgios(e.getTauxInteretAgios());
        return d;
    }

    public static TypeProduit toEntity(TypeProduitDto d) {
        if (d == null) return null;
        TypeProduit e = new TypeProduit();
        // On ne peut mapper que ce que le modèle expose
        e.setIntitule(d.getIntitule());
        e.setCotisationCarte(d.getCotisationCarte());
        e.setTauxInteretAgios(d.getTauxInteretsAgios());
        return e;
    }
}