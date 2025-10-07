package com.banque.service.impl;

import com.banque.model.ProduitBancaire;
import com.banque.repository.ProduitBancaireRepository;
import com.banque.service.ProduitBancaireService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProduitBancaireServiceImpl implements ProduitBancaireService {
    private ProduitBancaireRepository ProduitBancaireRepository;

    @Autowired
    public ProduitBancaireServiceImpl(ProduitBancaireRepository ProduitBancaireRepository) {
        this.ProduitBancaireRepository = ProduitBancaireRepository;
    }

    @Override
    public List<ProduitBancaire> getAllProduitBancaire()
    {
        return ProduitBancaireRepository.findAll();
    }

    @Override
    public ProduitBancaire createProduitBancaire(ProduitBancaire ProduitBancaire)
    {
        return ProduitBancaireRepository.save(ProduitBancaire);
    }

    @Override
    public ProduitBancaire getProduitBancaireById(Long id)
    {
        return ProduitBancaireRepository.findById(id).orElseThrow();
    }

    @Override
    public ProduitBancaire updateProduitBancaire(ProduitBancaire ProduitBancaire)
    {
        return ProduitBancaireRepository.save(ProduitBancaire);
    }

    @Override
    public void deleteProduitBancaireById(Long id)
    {
        ProduitBancaireRepository.findById(id).orElseThrow();
        ProduitBancaireRepository.deleteById(id);
    }
}
