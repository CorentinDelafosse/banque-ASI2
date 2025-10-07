package com.banque.service.impl;

import com.banque.model.ClientBancaire;
import com.banque.repository.ClientBancaireRepository;
import com.banque.service.ClientBancaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientBancaireServiceImpl implements ClientBancaireService {
    private ClientBancaireRepository ClientBancaireRepository;

    @Autowired
    public ClientBancaireServiceImpl(ClientBancaireRepository ClientBancaireRepository) {
        this.ClientBancaireRepository = ClientBancaireRepository;
    }

    @Override
    public List<ClientBancaire> getAllClientBancaire()
    {
        return ClientBancaireRepository.findAll();
    }

    @Override
    public ClientBancaire createClientBancaire(ClientBancaire ClientBancaire)
    {
        return ClientBancaireRepository.save(ClientBancaire);
    }

    @Override
    public ClientBancaire getClientBancaireById(Long id)
    {
        return ClientBancaireRepository.findById(id).orElseThrow();
    }

    @Override
    public ClientBancaire updateClientBancaire(ClientBancaire ClientBancaire)
    {
        return ClientBancaireRepository.save(ClientBancaire);
    }

    @Override
    public void deleteClientBancaireById(Long id)
    {
        ClientBancaireRepository.findById(id).orElseThrow();
        ClientBancaireRepository.deleteById(id);
    }
}
