package com.hubertkulas.backendpatronage.service;

import com.hubertkulas.backendpatronage.dto.RoomReservationDto;
import com.hubertkulas.backendpatronage.model.RoomReservation;
import com.hubertkulas.backendpatronage.repository.RoomReservationRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        RoomReservation roomReservation = convertToEntity(roomReservationDto);
        validatePersonalId(roomReservation);
        roomReservation = roomReservationRepository.save(roomReservation);
        return convertToDto(roomReservation);
    }


    @Override
    public RoomReservationDto update(Long id, RoomReservationDto roomReservationDto) {
        RoomReservation roomReservation = convertToEntity(roomReservationDto);
        validatePersonalId(roomReservation);
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

    private void validatePersonalId(RoomReservation roomReservation) {
        List<RoomReservation> roomReservations = roomReservationRepository.findAll();

        roomReservations.forEach(newRoomReservation -> {
            if (newRoomReservation.getPersonalId().equals(roomReservation.getPersonalId())) {
                throw new IllegalArgumentException("'personal id' field is not unique");
            }
        });

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
