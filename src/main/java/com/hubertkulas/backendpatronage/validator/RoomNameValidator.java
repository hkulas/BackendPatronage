package com.hubertkulas.backendpatronage.validator;

import com.hubertkulas.backendpatronage.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RoomNameValidator implements ConstraintValidator<UniqueRoomName, String> {

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public void initialize(UniqueRoomName constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (roomRepository == null) {
            return true;
        }

        return roomRepository.findByRoomName(value).size() == 0;
    }
}
