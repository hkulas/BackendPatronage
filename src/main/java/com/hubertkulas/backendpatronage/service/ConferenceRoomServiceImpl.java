package com.hubertkulas.backendpatronage.service;

import com.hubertkulas.backendpatronage.model.ConferenceRoom;
import com.hubertkulas.backendpatronage.repository.ConferenceRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConferenceRoomServiceImpl implements ConferenceRoomService {

    @Autowired
    private ConferenceRoomRepository conferenceRoomRepository;

    @Override
    public List<ConferenceRoom> getAll() {
        return conferenceRoomRepository.findAll();
    }

    @Override
    public ConferenceRoom get(Long id) {
        return conferenceRoomRepository.getOne(id);
    }

    @Override
    public void add(ConferenceRoom conferenceRoom) {
        conferenceRoomRepository.save(conferenceRoom);
    }

    @Override
    public ConferenceRoom update(Long id, ConferenceRoom conferenceRoom) {
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
        }).orElseGet(() ->{
            conferenceRoom.setId(id);
            return conferenceRoomRepository.save(conferenceRoom);
        });
    }

    @Override
    public void delete(Long id) {
        conferenceRoomRepository.deleteById(id);
    }
}
