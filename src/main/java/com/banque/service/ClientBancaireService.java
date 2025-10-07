package com.banque.service;

import com.banque.model.ClientBancaire;

import java.util.List;

public interface ClientBancaireService {
    public List<ClientBancaire> getAllClientBancaire();
    public ClientBancaire createClientBancaire(ClientBancaire ClientBancaire);
    public ClientBancaire getClientBancaireById(Long id);
    public ClientBancaire updateClientBancaire(ClientBancaire ClientBancaire);
    public void deleteClientBancaireById(Long id);
}
