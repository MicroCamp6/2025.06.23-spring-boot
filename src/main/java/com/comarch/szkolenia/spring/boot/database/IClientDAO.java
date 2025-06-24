package com.comarch.szkolenia.spring.boot.database;

import com.comarch.szkolenia.spring.boot.model.Client;

import java.util.List;
import java.util.Optional;

public interface IClientDAO {
    List<Client> getAll();
    Optional<Client> getById(long id);
    void delete(long id);
    void persist(Client client);
}
