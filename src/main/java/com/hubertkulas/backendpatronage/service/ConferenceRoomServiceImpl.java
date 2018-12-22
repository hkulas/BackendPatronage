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
    public void update(Long id, ConferenceRoom conferenceRoom) {
        conferenceRoomRepository.save(conferenceRoom);
    }

    @Override
    public void delete(Long id) {
        conferenceRoomRepository.deleteById(id);
    }
}
