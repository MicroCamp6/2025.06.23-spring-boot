package com.comarch.szkolenia.spring.boot.services.impl;

import com.comarch.szkolenia.spring.boot.model.Client;
import com.comarch.szkolenia.spring.boot.services.IClientService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

public class ClienService2 implements IClientService {
    @Override
    public List<Client> getAll() {
        return List.of();
    }

    @Override
    public List<Client> getByNameAndSurname(String name, String surname) {
        return List.of();
    }

    @Override
    public Optional<Client> getById(long id) {
        return Optional.empty();
    }

    @Override
    public void update(Client client, long id) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public void persist(Client client) {

    }
}
