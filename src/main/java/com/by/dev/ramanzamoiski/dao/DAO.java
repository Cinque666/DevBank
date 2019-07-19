package com.by.dev.ramanzamoiski.dao;

import java.util.List;

public interface DAO<T> {

    List<?> getAll();

    void add(T t);
}
