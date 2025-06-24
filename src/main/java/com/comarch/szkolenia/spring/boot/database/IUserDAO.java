package com.comarch.szkolenia.spring.boot.database;

import com.comarch.szkolenia.spring.boot.model.User;

import java.util.Optional;

public interface IUserDAO {
    Optional<User> getByLogin(String login);
}
