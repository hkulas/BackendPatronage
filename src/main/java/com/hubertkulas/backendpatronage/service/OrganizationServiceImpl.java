package com.hubertkulas.backendpatronage.service;

import com.hubertkulas.backendpatronage.model.Organization;
import com.hubertkulas.backendpatronage.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationServiceImpl implements OrganizationService {

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
        validateOrganizationName(organization);
        organizationRepository.save(organization);
    }

    @Override
    public Organization update(Long id, Organization organization) {
        validateOrganizationName(organization);
        return organizationRepository.findById(id).map(newOrganization -> {
            newOrganization.setOrganizationName(organization.getOrganizationName());
            newOrganization.setConferenceRooms(organization.getConferenceRooms());

            return organizationRepository.save(newOrganization);
        }).orElseGet(() -> {
            organization.setId(id);
            return organizationRepository.save(organization);
        });
    }

    @Override
    public void delete(Long id) {
        organizationRepository.deleteById(id);
    }

    private void validateOrganizationName(Organization organization){
        List<Organization> organizations = organizationRepository.findAll();
        for (Organization newOrganization : organizations) {
            if (newOrganization.getOrganizationName().equals(organization.getOrganizationName())) {
                throw new IllegalArgumentException("'organization name' field is not unique");
            }

        }
    }
}