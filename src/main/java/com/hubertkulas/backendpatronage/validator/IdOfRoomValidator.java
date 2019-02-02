package com.hubertkulas.backendpatronage.validator;

import com.hubertkulas.backendpatronage.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IdOfRoomValidator implements ConstraintValidator<UniqueIdOfRoom, String> {

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public void initialize(UniqueIdOfRoom constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (roomRepository == null) {
            return true;
        }
        return roomRepository.findByIdOfRoom(value).size() == 0;
    }
}
