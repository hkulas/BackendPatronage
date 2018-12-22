package com.hubertkulas.backendpatronage.service;

import com.hubertkulas.backendpatronage.model.Organization;
import com.hubertkulas.backendpatronage.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationServiceImpl implements  OrganizationService {

    @Autowired
    private OrganizationRepository organizationRepository;

    @Override
    public List<Organization> getAll() {
        return organizationRepository.findAll();
    }

    @Override
    public Organization get(Long id) {
        return organizationRepository.getOne(id);
    }

    @Override
    public void add(Organization organization) {
        organizationRepository.save(organization);
    }

    @Override
    public void update(Long id,Organization organization) {
        organizationRepository.save(organization);
    }

    @Override
    public void delete(Long id) {
        organizationRepository.deleteById(id);
    }
}
