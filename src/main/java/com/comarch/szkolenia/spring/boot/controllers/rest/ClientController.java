package com.comarch.szkolenia.spring.boot.controllers.rest;

import com.comarch.szkolenia.spring.boot.database.IClientDAO;
import com.comarch.szkolenia.spring.boot.model.Client;
import com.comarch.szkolenia.spring.boot.model.dto.ClientsDTO;
import com.comarch.szkolenia.spring.boot.services.IClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/client")
public class ClientController {
    private final IClientService clientService;

    @GetMapping("")
    public ClientsDTO get(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "surname", required = false) String surname) {

        if(name == null && surname == null) {
            return new ClientsDTO(this.clientService.getAll());
        }
        return new ClientsDTO(this.clientService.getByNameAndSurname(name, surname));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getById(@PathVariable("id") long id) {
        return this.clientService.getById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public Client update(@RequestBody Client client,
                         @PathVariable("id") long id) {
        this.clientService.update(client, id);
        return client;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id) {
        this.clientService.delete(id);
    }

    @PostMapping("")
    public ResponseEntity<Client> create(@RequestBody Client client) {
        this.clientService.persist(client);
        return ResponseEntity.status(201).body(client);
    }
}
