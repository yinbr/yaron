package com.yaron.server.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T, ID extends Serializable> {
    T findById(ID id);

    List<T> findAll();

    long countAll();

    void create(T entity);

    void delete(T entity);

    T merge(T entity);

    void clear();

    void flush();

    List<T> findByNamedQuery(String namedQueryString, Object... values);

    T findUniqueResultByNamedQuery(String namedQueryString, Object... values);

    void executeUpdateByNamedQuery(String query, Object... values);
}
