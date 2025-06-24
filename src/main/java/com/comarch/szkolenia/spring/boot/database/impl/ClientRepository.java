package com.comarch.szkolenia.spring.boot.database.impl;

import com.comarch.szkolenia.spring.boot.database.IClientDAO;
import com.comarch.szkolenia.spring.boot.model.Client;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository implements IClientDAO {
    private final List<Client> clients = new ArrayList<>(List.of(
            new Client(1, "Janusz", "Kowalski",
                    30, "123123123123", true),
            new Client(2, "Karol", "Malinowski",
                    40, "234234234", true),
            new Client(3, "Wiesiek", "Jakis",
                    50, "345345345345", false),
            new Client(4, "Janusz", "Fajny",
                    60, "66786786788", false)
    ));

    private int idSequence = 4;

    @Override
    public List<Client> getAll() {
        return this.clients;
    }

    @Override
    public Optional<Client> getById(long id) {
        return this.clients.stream()
                .filter(c -> c.getId() == id)
                .findFirst();
    }

    @Override
    public void delete(long id) {
        //getById(id).ifPresent(this.clients::remove);

        /*Iterator<Client> iterator = this.clients.iterator();
        while (iterator.hasNext()) {
            if(iterator.next().getId() == id) {
                iterator.remove();
            }
        }*/

        this.clients.removeIf(c -> c.getId() == id);
    }

    @Override
    public void persist(Client client) {
        client.setId(++this.idSequence);
        this.clients.add(client);
    }
}
