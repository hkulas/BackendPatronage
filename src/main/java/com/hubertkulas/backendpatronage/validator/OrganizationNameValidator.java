package com.hubertkulas.backendpatronage.validator;

import com.hubertkulas.backendpatronage.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class OrganizationNameValidator implements ConstraintValidator<UniqueOrganizationName, String> {
    @Autowired
    private OrganizationRepository organizationRepository;

    @Override
    public void initialize(UniqueOrganizationName constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (organizationRepository == null) {
            return true;
        }

        return organizationRepository.findByOrganizationName(value).size() == 0;
    }
}
