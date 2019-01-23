package com.hubertkulas.backendpatronage.repository;

import com.hubertkulas.backendpatronage.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrganizationRepository extends JpaRepository<Organization,Long> {
List<Organization> findByOrganizationName(String organizationName);
}
