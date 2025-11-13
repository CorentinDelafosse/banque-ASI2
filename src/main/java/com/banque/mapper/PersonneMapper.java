package com.banque.mapper;

import com.banque.dataTransferObjects.PersonneDto;
import com.banque.model.Personne;
import com.banque.model.PersonneMorale;
import com.banque.model.PersonnePhysique;

public class PersonneMapper {

    public static PersonneDto toDTO(Personne e) {
        if (e == null) return null;
        PersonneDto d = new PersonneDto();
        d.setAdresse(e.getAdresse());

        if (e instanceof PersonnePhysique pp) {
            d.setTypePersonne("PHYSIQUE");
            // “nom” du DTO = nom lisible (prenom + nom)
            String nomComplet = (pp.getPrenom() == null ? "" : pp.getPrenom() + " ")
                    + (pp.getNom() == null ? "" : pp.getNom());
            d.setNom(nomComplet.trim());
        } else if (e instanceof PersonneMorale pm) {
            d.setTypePersonne("MORALE");
            d.setNom(pm.getRaisonSociale()); // le DTO veut un seul champ “nom”
        } else {
            // Sécurité si de nouveaux sous-types apparaissent
            d.setTypePersonne("INCONNU");
            d.setNom(null);
        }
        return d;
    }

    public static Personne toEntity(PersonneDto d) {
        if (d == null) return null;

        String type = d.getTypePersonne() == null ? "" : d.getTypePersonne().trim().toUpperCase();

        if ("MORALE".equals(type)) {
            PersonneMorale pm = new PersonneMorale();
            pm.setAdresse(d.getAdresse());
            pm.setRaisonSociale(d.getNom()); // SIRET et TypePersonneMorale non disponibles dans le DTO
            return pm;
        } else {
            // Par défaut on considère PHYSIQUE : on tente de séparer "prenom nom"
            String prenom = null, nom = null;
            if (d.getNom() != null) {
                String[] parts = d.getNom().trim().split("\\s+", 2);
                if (parts.length == 2) { prenom = parts[0]; nom = parts[1]; }
                else { nom = d.getNom().trim(); }
            }
            PersonnePhysique pp = new PersonnePhysique();
            pp.setAdresse(d.getAdresse());
            pp.setPrenom(prenom);
            pp.setNom(nom);
            return pp;
        }
    }
}