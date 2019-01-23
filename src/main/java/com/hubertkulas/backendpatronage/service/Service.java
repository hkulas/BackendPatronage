package com.hubertkulas.backendpatronage.service;

import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

@Validated
public interface Service<T> {
    List<T> getAll();

    T get(Long id);

    T add(@Valid T dtoModel);

    T update(Long id,@Valid T dtoModel);

    void delete(Long id);
}
