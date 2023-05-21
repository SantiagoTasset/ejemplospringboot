package com.eoi.ejemplospringboot.services;
import java.util.List;

public interface GenericService<T, I, R > {

    T getById(I i);

    T create(T entity);

    T update(I i, T entity);

    void delete(I i);

    List<T> listAll();

    R getRepository();
}

