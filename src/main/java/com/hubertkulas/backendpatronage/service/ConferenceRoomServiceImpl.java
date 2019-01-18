package com.hubertkulas.backendpatronage.service;

import com.hubertkulas.backendpatronage.dto.ConferenceRoomDto;
import com.hubertkulas.backendpatronage.model.ConferenceRoom;
import com.hubertkulas.backendpatronage.repository.ConferenceRoomRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConferenceRoomServiceImpl implements ConferenceRoomService {

    @Autowired
    private ConferenceRoomRepository conferenceRoomRepository;

    @Override
    public List<ConferenceRoomDto> getAll() {
        var conferenceRooms = conferenceRoomRepository.findAll();
        var conferenceRoomDtos = new ArrayList<ConferenceRoomDto>();

        for (ConferenceRoom conferenceRoom : conferenceRooms) {
            ConferenceRoomDto conferenceRoomDto = convertToDto(conferenceRoom);
            conferenceRoomDtos.add(conferenceRoomDto);
        }
        return conferenceRoomDtos;
    }

    @Override
    public ConferenceRoomDto get(Long id) {
        validateId(id);
        return convertToDto(conferenceRoomRepository.getOne(id));
    }

    @Override
    public void add(ConferenceRoomDto conferenceRoomDto) {
        ConferenceRoom conferenceRoom = convertToEntity(conferenceRoomDto);
        validateRoomNameIdOfRoom(conferenceRoom);
        conferenceRoomRepository.save(conferenceRoom);
    }

    @Override
    public void update(Long id, ConferenceRoomDto conferenceRoomDto) {
        validateId(id);
        ConferenceRoom conferenceRoom = convertToEntity(conferenceRoomDto);
        validateRoomNameIdOfRoom(conferenceRoom);
        returnUpdate(id, conferenceRoom);


    }

    @Override
    public void delete(Long id) {
        validateId(id);
        conferenceRoomRepository.deleteById(id);
    }

    private void validateRoomNameIdOfRoom(ConferenceRoom conferenceRoom) {
        List<ConferenceRoom> conferenceRooms = conferenceRoomRepository.findAll();

        conferenceRooms.forEach(newConferenceRoom -> {
            if (newConferenceRoom.getRoomName().equals(conferenceRoom.getRoomName())) {
                throw new IllegalArgumentException("'room name' field is not unique");
            }
            if (newConferenceRoom.getIdOfRoom().equals(conferenceRoom.getIdOfRoom())) {
                throw new IllegalArgumentException("'id of room' field is not unique");
            }
        });

    }

    private void validateId(Long id) {
        if (id > conferenceRoomRepository.findAll().size()) {
            throw new IllegalArgumentException("Conference room with specified id does not exist");
        }
    }

    private ConferenceRoomDto convertToDto(ConferenceRoom conferenceRoom) {
        var conferenceRoomDto = new ConferenceRoomDto();
        BeanUtils.copyProperties(conferenceRoom, conferenceRoomDto);
        return conferenceRoomDto;
    }

    private ConferenceRoom convertToEntity(ConferenceRoomDto conferenceRoomDto) {

        var conferenceRoom = new ConferenceRoom();
        try {
            BeanUtils.copyProperties(conferenceRoomDto, conferenceRoom);
        } catch (Exception ex) {
            throw new IllegalArgumentException("Objerct with specified id does not exist");
        }
        return conferenceRoom;
    }

    private ConferenceRoom returnUpdate(Long id, ConferenceRoom conferenceRoom) {
        return conferenceRoomRepository.findById(id).map(newConferenceRoom -> {
            newConferenceRoom.setRoomName(conferenceRoom.getRoomName());
            newConferenceRoom.setIdOfRoom(conferenceRoom.getIdOfRoom());
            newConferenceRoom.setFloor(conferenceRoom.getFloor());
            newConferenceRoom.setIsAvailable(conferenceRoom.getIsAvailable());
            newConferenceRoom.setStandingPlaces(conferenceRoom.getStandingPlaces());
            newConferenceRoom.setSeats(conferenceRoom.getSeats());
            newConferenceRoom.setHangingPlaces(conferenceRoom.getSeats());
            newConferenceRoom.setConferenceRoomEquipment(conferenceRoom.getConferenceRoomEquipment());

            return conferenceRoomRepository.save(newConferenceRoom);
        }).orElseGet(() -> {
            conferenceRoom.setId(id);
            return conferenceRoomRepository.save(conferenceRoom);
        });
    }


}
