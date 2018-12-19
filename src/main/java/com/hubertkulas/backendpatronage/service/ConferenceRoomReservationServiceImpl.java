package com.hubertkulas.backendpatronage.service;

import com.hubertkulas.backendpatronage.repository.ConferenceRoomReservationRepository;
import com.hubertkulas.backendpatronage.model.ConferenceRoomReservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConferenceRoomReservationServiceImpl implements ConferenceRoomReservationService {

    @Autowired
    private ConferenceRoomReservationRepository conferenceRoomReservationRepository;

    @Override
    public List<ConferenceRoomReservation> getAll() {
        return conferenceRoomReservationRepository.findAll();
    }

    @Override
    public ConferenceRoomReservation get(Long id) {
        return conferenceRoomReservationRepository.getOne(id);
    }

    @Override
    public void add(ConferenceRoomReservation conferenceRoomReservation) {
        conferenceRoomReservationRepository.save(conferenceRoomReservation);

    }

    @Override
    public void update(Long id, ConferenceRoomReservation conferenceRoomReservation) {
        conferenceRoomReservationRepository.save(conferenceRoomReservation);
    }

    @Override
    public void delete(Long id) {
        conferenceRoomReservationRepository.deleteById(id);

    }
}
