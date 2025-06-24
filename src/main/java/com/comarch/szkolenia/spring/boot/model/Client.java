package com.comarch.szkolenia.spring.boot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    private long id;
    private String name;
    private String surname;
    private int age;
    private String pesel;
    private boolean active;
}
