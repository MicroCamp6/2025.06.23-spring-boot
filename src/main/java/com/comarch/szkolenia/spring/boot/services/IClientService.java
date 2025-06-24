package com.comarch.szkolenia.spring.boot.services;

import com.comarch.szkolenia.spring.boot.model.Client;

import java.util.List;
import java.util.Optional;

public interface IClientService {
    List<Client> getAll();
    List<Client> getByNameAndSurname(String name, String surname);
    Optional<Client> getById(long id);
    void update(Client client, long id);
    void delete(long id);
    void persist(Client client);
}
