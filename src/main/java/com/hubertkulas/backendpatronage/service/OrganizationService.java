package com.hubertkulas.backendpatronage.service;

import com.hubertkulas.backendpatronage.dto.OrganizationDto;

import java.util.List;

public interface OrganizationService {
    List<OrganizationDto> getAll();

    OrganizationDto get(Long id);

    void add(OrganizationDto organizationDto);

    void update(Long id, OrganizationDto organizationDto);

    void delete(Long id);
}
