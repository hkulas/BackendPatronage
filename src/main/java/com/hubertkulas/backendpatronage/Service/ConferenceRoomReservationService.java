package com.hubertkulas.backendpatronage.Service;

import com.hubertkulas.backendpatronage.model.ConferenceRoomReservation;

import java.util.List;

public interface ConferenceRoomReservationService {

    public List<ConferenceRoomReservation> getAll();

    public ConferenceRoomReservation get(Long id);

    public void add(ConferenceRoomReservation conferenceRoomReservation);

    public void update(Long id, ConferenceRoomReservation conferenceRoomReservation);

    public void delete(Long id);
}
