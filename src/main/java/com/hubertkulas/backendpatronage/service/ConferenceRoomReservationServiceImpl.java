package com.hubertkulas.backendpatronage.service;

import com.hubertkulas.backendpatronage.model.ConferenceRoomReservation;
import com.hubertkulas.backendpatronage.repository.ConferenceRoomReservationRepository;
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
        validatePersonalId(conferenceRoomReservation);
        conferenceRoomReservationRepository.save(conferenceRoomReservation);

    }

    @Override
    public ConferenceRoomReservation update(Long id, ConferenceRoomReservation conferenceRoomReservation) {
        validatePersonalId(conferenceRoomReservation);
        return conferenceRoomReservationRepository.findById(id).map(newConferenceRoomReservation -> {
            newConferenceRoomReservation.setPersonalId(conferenceRoomReservation.getPersonalId());
            newConferenceRoomReservation.setStartOfReservation(conferenceRoomReservation.getStartOfReservation());
            newConferenceRoomReservation.setEndOfReservation(conferenceRoomReservation.getEndOfReservation());
            return conferenceRoomReservationRepository.save(newConferenceRoomReservation);
        }).orElseGet(() -> {
            conferenceRoomReservation.setId(id);
            return conferenceRoomReservationRepository.save(conferenceRoomReservation);
        });
    }

    @Override
    public void delete(Long id) {
        conferenceRoomReservationRepository.deleteById(id);

    }

    private void validatePersonalId(ConferenceRoomReservation conferenceRoomReservation) {
        List<ConferenceRoomReservation> conferenceRoomReservations = conferenceRoomReservationRepository.findAll();
        for (ConferenceRoomReservation newConferenceRoomReservation : conferenceRoomReservations) {
            if (newConferenceRoomReservation.getPersonalId().equals(conferenceRoomReservation.getPersonalId())) {
                throw new IllegalArgumentException("'personal id' field is not unique");
            }

        }
    }


}
