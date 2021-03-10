package com.example.webshop.repository;

import java.util.List;

public interface ICrudRepository<T> {
    T create(T t);
    List<T> readAll();
    T getProduct(long id);
    void update(T t);
    void delete(long id);
}
