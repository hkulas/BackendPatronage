package com.hubertkulas.backendpatronage.service;

import java.util.List;

public interface Service<T> {
    List<T> getAll();

    T get(Long id);

    T add(T dtoModel);

    T update(Long id, T dtoModel);

    void delete(Long id);
}
