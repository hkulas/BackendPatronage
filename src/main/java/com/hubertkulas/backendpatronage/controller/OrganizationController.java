package com.hubertkulas.backendpatronage.controller;

import com.hubertkulas.backendpatronage.dto.OrganizationDto;
import com.hubertkulas.backendpatronage.service.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/organizations")
public class OrganizationController {

// test message
    private final Service<OrganizationDto> organizationService;

    public OrganizationController(Service<OrganizationDto> organizationService) {
        this.organizationService = organizationService;
    }


    @GetMapping("/{id}")
    public OrganizationDto get(@PathVariable Long id) {
        return organizationService.get(id);

    }

    @GetMapping()
    public List<OrganizationDto> getAll() {
        return organizationService.getAll();
    }

    @PostMapping
    public OrganizationDto add(@RequestBody OrganizationDto organizationDto) {
        return organizationService.add(organizationDto);
    }

    @PutMapping(value = "/{id}")
    public OrganizationDto update(@RequestBody OrganizationDto organizationDto, @PathVariable Long id) {
        return organizationService.update(id, organizationDto);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
        organizationService.delete(id);
    }
}
