package com.hubertkulas.backendpatronage.controller;

import com.hubertkulas.backendpatronage.model.Organization;
import com.hubertkulas.backendpatronage.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Organization")
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    @RequestMapping("/{id}")
    public Organization get(@PathVariable Long id){
        return organizationService.get(id);

    }
    @RequestMapping()
    public List<Organization> getAll(){
        return organizationService.getAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void add(@RequestBody Organization organization){
        organizationService.add(organization);
    }

    @RequestMapping(method = RequestMethod.PUT, value ="/{id}")
    public void update(@RequestBody Organization organization, @PathVariable Long id){
        organizationService.update(id,organization);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void delete(@PathVariable Long id){
        organizationService.delete(id);
    }
}
