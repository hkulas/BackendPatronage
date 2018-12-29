package com.hubertkulas.backendpatronage.service;

import com.hubertkulas.backendpatronage.model.ConferenceRoom;

import java.util.List;


public interface ConferenceRoomService {

    List<ConferenceRoom> getAll();

    ConferenceRoom get(Long id);

    void add(ConferenceRoom conferenceRoom);

    ConferenceRoom update(Long id, ConferenceRoom conferenceRoom);

    void delete(Long id);
}
