package com.comarch.szkolenia.spring.boot.database;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
public class NameRepository implements INameDAO {
    private final List<String> names = List.of(
            "Janusz",
            "Wiesiek",
            "Mateusz",
            "Bogdan",
            "Zbyszek"
    );

    @Override
    public List<String> getAll() {
        return this.names;
    }

    @Override
    public String getRandom() {
        return this.names.get(new Random().nextInt(this.names.size()));
    }
}
