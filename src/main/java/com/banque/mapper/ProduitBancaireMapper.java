package com.banque.mapper;

import com.banque.dataTransferObjects.ClientBancaireDto;
import com.banque.dataTransferObjects.OperationDto;
import com.banque.dataTransferObjects.ProduitBancaireDto;
import com.banque.dataTransferObjects.TypeProduitDto;
import com.banque.model.Operation;
import com.banque.model.ProduitBancaire;
import com.banque.model.TypeProduit;

import java.util.LinkedHashSet;
import java.util.stream.Collectors;

public class ProduitBancaireMapper {

    public static ProduitBancaireDto toDTO(ProduitBancaire e, boolean includeOperations) {
        if (e == null) return null;

        TypeProduitDto typeDto = TypeProduitMapper.toDTO(e.getTypeProduit());
        // Le modèle fourni n’a PAS de lien vers ClientBancaire dans ProduitBancaire
        ClientBancaireDto clientDto = null;

        ProduitBancaireDto d = new ProduitBancaireDto(
                e.getNumeroCompte(),
                e.getSolde_courant(),
                typeDto,
                clientDto
        );

        if (includeOperations && e.getOperations() != null) {
            d.setOperationDtos(
                    e.getOperations().stream()
                            .map(OperationMapper::toDTO)
                            .collect(Collectors.toCollection(LinkedHashSet::new))
            );
        }
        return d;
    }

    public static ProduitBancaire toEntity(ProduitBancaireDto d) {
        if (d == null) return null;
        ProduitBancaire e = new ProduitBancaire();
        e.setNumeroCompte(d.getNumeroCompte());
        e.setSolde_courant(d.getSoldeCourant());
        // Les relations sont résolues au service :
        // - typeProduit depuis d.getTypeProduitDto()
        // - opérations depuis d.getOperationDtos()
        return e;
    }

    /** Helpers si le service a déjà résolu les associations */
    public static void attachTypeProduit(ProduitBancaire e, TypeProduit type) {
        e.setTypeProduit(type);
        if (type != null && !type.getProduitsBancaires().contains(e)) {
            type.getProduitsBancaires().add(e);
        }
    }

    public static void attachOperations(ProduitBancaire e, Iterable<OperationDto> opDtos) {
        if (e == null || opDtos == null) return;
        for (OperationDto od : opDtos) {
            Operation op = OperationMapper.toEntity(od);
            e.addOperation(op); // maintient la bidirectionnalité (setProduitBancaire)
        }
    }
}