package com.banque.service;

import com.banque.model.ProduitBancaire;

import java.util.List;

public interface ProduitBancaireService {
    public List<ProduitBancaire> getAllProduitBancaire();
    public ProduitBancaire createProduitBancaire(ProduitBancaire ProduitBancaire);
    public ProduitBancaire getProduitBancaireById(Long id);
    public ProduitBancaire updateProduitBancaire(ProduitBancaire ProduitBancaire);
    public void deleteProduitBancaireById(Long id);
}
