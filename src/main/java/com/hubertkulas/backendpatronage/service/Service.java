package com.hubertkulas.backendpatronage.service;

import java.util.List;

public interface Service<T> {
    List<T> getAll();

    T get(Long id);

    void add(T dtoModel);

    void update(Long id, T dtoModel);

    void delete(Long id);
}
