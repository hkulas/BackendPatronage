package com.hubertkulas.backendpatronage.service;

import com.hubertkulas.backendpatronage.model.Organization;

import java.util.List;

public interface OrganizationService {
    List<Organization> getAll();

    Organization get(Long id);

    void add(Organization organization);

    void update(Long id, Organization organization);

    void delete(Long id);
}
