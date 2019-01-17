package com.hubertkulas.backendpatronage.controller;

import com.hubertkulas.backendpatronage.dto.OrganizationDto;
import com.hubertkulas.backendpatronage.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Organizations")
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    @RequestMapping("/{id}")
    public OrganizationDto get(@PathVariable Long id){
        return organizationService.get(id);

    }
    @RequestMapping()
    public List<OrganizationDto> getAll(){
        return organizationService.getAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void add(@RequestBody OrganizationDto organizationDto){
        organizationService.add(organizationDto);
    }

    @RequestMapping(method = RequestMethod.PUT, value ="/{id}")
    public void update(@RequestBody OrganizationDto organizationDto, @PathVariable Long id){
        organizationService.update(id,organizationDto);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void delete(@PathVariable Long id){
        organizationService.delete(id);
    }
}
