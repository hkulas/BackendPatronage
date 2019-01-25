package com.hubertkulas.backendpatronage.service;

import com.hubertkulas.backendpatronage.dto.RoomReservationDto;
import com.hubertkulas.backendpatronage.exception.BadArgumentException;
import com.hubertkulas.backendpatronage.exception.RoomIsAlreadyReservedException;
import com.hubertkulas.backendpatronage.model.RoomReservation;
import com.hubertkulas.backendpatronage.repository.RoomReservationRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class RoomReservationService implements com.hubertkulas.backendpatronage.service.Service<RoomReservationDto> {


    @Autowired
    private RoomReservationRepository roomReservationRepository;

    @Override
    public List<RoomReservationDto> getAll() {

        var conferenceRoomReservations = roomReservationRepository.findAll();
        var conferenceRoomReservationDtos = new ArrayList<RoomReservationDto>();

        for (RoomReservation roomReservation : conferenceRoomReservations) {
            RoomReservationDto roomReservationDto = convertToDto(roomReservation);
            conferenceRoomReservationDtos.add(roomReservationDto);
        }
        return conferenceRoomReservationDtos;

    }

    @Override
    public RoomReservationDto get(Long id) {
        return convertToDto(roomReservationRepository.getOne(id));
    }

    @Override
    public RoomReservationDto add(RoomReservationDto roomReservationDto) {
        validationMethods(roomReservationDto);
        var roomReservation = convertToEntity(roomReservationDto);

        roomReservation = roomReservationRepository.save(roomReservation);
        return convertToDto(roomReservation);
    }



    @Override
    public RoomReservationDto update(Long id, RoomReservationDto roomReservationDto) {
        validationMethods(roomReservationDto);
        var roomReservation = convertToEntity(roomReservationDto);

        return roomReservationRepository.findById(id).map(newRoomReservation -> {
            newRoomReservation.setPersonalId(roomReservation.getPersonalId());
            newRoomReservation.setStartOfReservation(roomReservation.getStartOfReservation());
            newRoomReservation.setEndOfReservation(roomReservation.getEndOfReservation());
            newRoomReservation = roomReservationRepository.save(newRoomReservation);
            return convertToDto(newRoomReservation);
        }).orElseGet(() -> {
            roomReservation.setId(id);
            RoomReservation roomReservation1 = roomReservationRepository.save(roomReservation);
            return convertToDto(roomReservation1);
        });
    }

    @Override
    public void delete(Long id) {

        roomReservationRepository.deleteById(id);

    }
    private void validationMethods(RoomReservationDto roomReservationDto) {
        var roomReservation = convertToEntity(roomReservationDto);

        validatePersonalId(roomReservation);
        reservationIsToShortOrToLong(roomReservation.getStartOfReservation(),roomReservation.getEndOfReservation());
        beginIsBeforeEnd(roomReservation.getStartOfReservation(),roomReservation.getEndOfReservation());
        isReserved(roomReservation);
    }


    private void validatePersonalId(RoomReservation roomReservation) {
        var roomReservations = roomReservationRepository.findByPersonalId(roomReservation.getPersonalId());
        if(roomReservations.size()!=0){
            throw new IllegalArgumentException("'personal id' field is not unique");
        }

    }
    private void beginIsBeforeEnd(LocalDateTime begin, LocalDateTime end){

        var seconds = Duration.between(begin, end).getSeconds();

        if(seconds <=0){
            throw new BadArgumentException("The end date you entered is before the start date");
        }
    }
    private void isReserved(RoomReservation roomReservation) {
        List<RoomReservation> roomReservations = roomReservationRepository.findAllByStartOfReservationLessThanEqualAndEndOfReservationGreaterThanEqual(roomReservation.getEndOfReservation(),roomReservation.getStartOfReservation());
        if(roomReservations.size()!=0){
            throw new RoomIsAlreadyReservedException();
        }
    }

    private void reservationIsToShortOrToLong(LocalDateTime begin, LocalDateTime end){
        var seconds = Duration.between(begin, end).getSeconds();
        if(seconds >=7200){
            throw new BadArgumentException("Your reservation is too long. It should be less than two hours");
        }
        else if(seconds <= 300){
            throw new BadArgumentException("Your reservation is too short. It should be more than five minutes");
        }
    }

    private RoomReservationDto convertToDto(RoomReservation roomReservation) {

        var roomReservationDto = new RoomReservationDto();
        BeanUtils.copyProperties(roomReservation, roomReservationDto);
        return roomReservationDto;
    }

    private RoomReservation convertToEntity(RoomReservationDto roomReservationDto) {

        var roomReservation = new RoomReservation();
        BeanUtils.copyProperties(roomReservationDto, roomReservation);
        return roomReservation;
    }



}
