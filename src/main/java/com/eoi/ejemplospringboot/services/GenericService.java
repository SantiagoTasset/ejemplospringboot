package com.eoi.ejemplospringboot.services;
import java.util.List;

public interface GenericService<T, ID, R > {

    T getById(ID id);

    T create(T entity);

    T update(ID id, T entity);

    void delete(ID id);

    List<T> listAll();

    R getRepository();
}

