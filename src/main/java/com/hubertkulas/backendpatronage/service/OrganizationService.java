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
        return convertToDto(organizationRepository.getOne(id));
    }

    @Override
    public OrganizationDto add(OrganizationDto organizationDto) {
        Organization organization = convertToEntity(organizationDto);
        organization = organizationRepository.save(organization);
        return convertToDto(organization);
    }

    @Override
    public OrganizationDto update(Long id, OrganizationDto organizationDto) {
        Organization organization = convertToEntity(organizationDto);

        return organizationRepository.findById(id).map(newOrganization -> {
            newOrganization.setOrganizationName(organization.getOrganizationName());
            newOrganization.setRooms(organization.getRooms());

            newOrganization = organizationRepository.save(newOrganization);
            return convertToDto(newOrganization);
        }).orElseGet(() -> {
            organization.setId(id);
            Organization organization1 = organizationRepository.save(organization);
            return convertToDto(organization1);
        });
    }


    @Override
    public void delete(Long id) {
        organizationRepository.deleteById(id);
    }


    private OrganizationDto convertToDto(Organization organization) {

        var organizationDto = new OrganizationDto();
        BeanUtils.copyProperties(organization, organizationDto);
        return organizationDto;
    }

    private Organization convertToEntity(OrganizationDto organizationDto) {

        var organization = new Organization();
        BeanUtils.copyProperties(organizationDto, organization);
        return organization;
    }

}