package com.comarch.szkolenia.spring.boot.services.impl;

import com.comarch.szkolenia.spring.boot.database.IClientDAO;
import com.comarch.szkolenia.spring.boot.model.Client;
import com.comarch.szkolenia.spring.boot.services.IClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService implements IClientService {
    private final IClientDAO clientDAO;


    @Override
    public List<Client> getAll() {
        return this.clientDAO.getAll();
    }

    @Override
    public List<Client> getByNameAndSurname(String name, String surname) {
        return clientDAO.getAll().stream()
                .filter(c -> name == null || c.getName().equals(name))
                .filter(c -> surname == null || c.getSurname().equals(surname))
                .toList();
    }

    @Override
    public Optional<Client> getById(long id) {
        return this.clientDAO.getById(id);
    }

    @Override
    public void update(Client client, long id) {
        Optional<Client> clientBox = this.clientDAO.getById(id);
        if(clientBox.isPresent()) {
            int i = this.clientDAO.getAll().indexOf(clientBox.get());
            this.clientDAO.getAll().set(i, client);
        }
    }

    @Override
    public void delete(long id) {
        this.clientDAO.delete(id);
    }

    @Override
    public void persist(Client client) {
        this.clientDAO.persist(client);
    }
}
