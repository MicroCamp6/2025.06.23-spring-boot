package com.comarch.szkolenia.spring.boot.database.impl;

import com.comarch.szkolenia.spring.boot.database.IUserDAO;
import com.comarch.szkolenia.spring.boot.model.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository implements IUserDAO {

    private final List<User> users = List.of(
            new User("admin", "admin"),
            new User("janusz", "janusz")
    );

    @Override
    public Optional<User> getByLogin(String login) {
        return this.users.stream()
                .filter(u -> u.getLogin().equals(login)).findFirst();
    }
}
