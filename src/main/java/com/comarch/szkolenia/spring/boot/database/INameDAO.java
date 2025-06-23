package com.comarch.szkolenia.spring.boot.database;

import java.util.List;

public interface INameDAO {
    List<String> getAll();
    String getRandom();
}
