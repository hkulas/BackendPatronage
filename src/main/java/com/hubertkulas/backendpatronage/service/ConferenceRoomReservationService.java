package com.hubertkulas.backendpatronage.service;

import com.hubertkulas.backendpatronage.model.ConferenceRoomReservation;

import java.util.List;

public interface ConferenceRoomReservationService {

    List<ConferenceRoomReservation> getAll();

    ConferenceRoomReservation get(Long id);

    void add(ConferenceRoomReservation conferenceRoomReservation);

    void update(Long id, ConferenceRoomReservation conferenceRoomReservation);

    void delete(Long id);
}
