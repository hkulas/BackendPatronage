package com.hubertkulas.backendpatronage.validator;

import com.hubertkulas.backendpatronage.repository.RoomReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class PersonalIdValidator implements ConstraintValidator<UniquePersonalId,String> {

    @Autowired
    private RoomReservationRepository roomReservationRepository;

    @Override
    public void initialize(UniquePersonalId constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(roomReservationRepository == null){
            return true;
        }
        return roomReservationRepository.findByPersonalId(value).size()==0;

    }
}
