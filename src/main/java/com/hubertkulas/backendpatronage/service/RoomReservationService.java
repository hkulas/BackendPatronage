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
        validateId(id);
        return convertToDto(roomReservationRepository.getOne(id));
    }

    @Override
    public void add(RoomReservationDto roomReservationDto) {
        RoomReservation roomReservation = convertToEntity(roomReservationDto);
        validatePersonalId(roomReservation);
        roomReservationRepository.save(roomReservation);

    }

    @Override
    public void update(Long id, RoomReservationDto roomReservationDto) {
        validateId(id);
        RoomReservation roomReservation = convertToEntity(roomReservationDto);
        validatePersonalId(roomReservation);
        returnUpdate(id, roomReservation);

    }

    @Override
    public void delete(Long id) {
        validateId(id);
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

    private void validateId(Long id) {
        if (id > roomReservationRepository.findAll().size()) {
            throw new IllegalArgumentException("Conference room reservation with specified id does not exist");
        }
    }

    private RoomReservationDto convertToDto(RoomReservation roomReservation) {

        var conferenceRoomReservationDto = new RoomReservationDto();
        BeanUtils.copyProperties(roomReservation, conferenceRoomReservationDto);
        return conferenceRoomReservationDto;
    }

    private RoomReservation convertToEntity(RoomReservationDto roomReservationDto) {

        var conferenceRoomReservation = new RoomReservation();
        BeanUtils.copyProperties(roomReservationDto, conferenceRoomReservation);
        return conferenceRoomReservation;
    }

    private RoomReservation returnUpdate(Long id, RoomReservation roomReservation) {
        return roomReservationRepository.findById(id).map(newRoomReservation -> {
            newRoomReservation.setPersonalId(roomReservation.getPersonalId());
            newRoomReservation.setStartOfReservation(roomReservation.getStartOfReservation());
            newRoomReservation.setEndOfReservation(roomReservation.getEndOfReservation());
            return roomReservationRepository.save(newRoomReservation);
        }).orElseGet(() -> {
            roomReservation.setId(id);
            return roomReservationRepository.save(roomReservation);
        });
    }


}
