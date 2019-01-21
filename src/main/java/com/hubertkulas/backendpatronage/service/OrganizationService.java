package com.hubertkulas.backendpatronage.service;

import com.hubertkulas.backendpatronage.dto.OrganizationDto;
import com.hubertkulas.backendpatronage.model.Organization;
import com.hubertkulas.backendpatronage.repository.OrganizationRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrganizationService implements com.hubertkulas.backendpatronage.service.Service<OrganizationDto> {

    @Autowired
    private OrganizationRepository organizationRepository;

    @Override
    public List<OrganizationDto> getAll() {
        var organizations = organizationRepository.findAll();
        var organizationDtos = new ArrayList<OrganizationDto>();

        for (Organization organization : organizations) {
            OrganizationDto organizationDto = convertToDto(organization);
            organizationDtos.add(organizationDto);
        }
        return organizationDtos;
    }

    @Override
    public OrganizationDto get(Long id) {
        validateId(id);
        return convertToDto(organizationRepository.getOne(id));
    }

    @Override
    public void add(OrganizationDto organizationDto) {
        Organization organization = convertToEntity(organizationDto);
        validateOrganizationName(organization);
        organizationRepository.save(organization);
    }

    @Override
    public void update(Long id, OrganizationDto organizationDto) {
        validateId(id);
        Organization organization = convertToEntity(organizationDto);
        validateOrganizationName(organization);
        updateReturn(id,organization);
    }

    @Override
    public void delete(Long id) {
        validateId(id);
        organizationRepository.deleteById(id);
    }

    private void validateOrganizationName(Organization organization){
        List<Organization> organizations = organizationRepository.findAll();
        organizations.forEach(newOrganization ->{
                if(newOrganization.getOrganizationName().equals(organization.getOrganizationName())){
                    throw new IllegalArgumentException("'organization name' field is not unique");
                }
        });
    }
    private void validateId(Long id) {
        if (id > organizationRepository.findAll().size()) {
            throw new IllegalArgumentException("Organization with specified id does not exist");
        }
    }
    private OrganizationDto convertToDto(Organization organization){

        var organizationDto= new OrganizationDto();
        BeanUtils.copyProperties(organization,organizationDto);
        return organizationDto;
    }

    private Organization convertToEntity(OrganizationDto organizationDto){

        var organization = new Organization();
        BeanUtils.copyProperties(organizationDto,organization);
        return organization;
    }

    public Organization updateReturn(Long id, Organization organization) {
        validateOrganizationName(organization);
        return organizationRepository.findById(id).map(newOrganization -> {
            newOrganization.setOrganizationName(organization.getOrganizationName());
            newOrganization.setRooms(organization.getRooms());

            return organizationRepository.save(newOrganization);
        }).orElseGet(() -> {
            organization.setId(id);
            return organizationRepository.save(organization);
        });
    }

}