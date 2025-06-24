package com.comarch.szkolenia.spring.boot.model.dto;

import com.comarch.szkolenia.spring.boot.model.Client;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class ClientsDTO {
    private final List<Client> clients;
}
