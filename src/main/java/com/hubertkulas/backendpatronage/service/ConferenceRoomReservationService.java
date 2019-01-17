package com.hubertkulas.backendpatronage.service;

import com.hubertkulas.backendpatronage.dto.ConferenceRoomReservationDto;

import java.util.List;

public interface ConferenceRoomReservationService {

    List<ConferenceRoomReservationDto> getAll();

    ConferenceRoomReservationDto get(Long id);

    void add(ConferenceRoomReservationDto conferenceRoomReservationDto);

    void update(Long id, ConferenceRoomReservationDto conferenceRoomReservationDto);

    void delete(Long id);
}
