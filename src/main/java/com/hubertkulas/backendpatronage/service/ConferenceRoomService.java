package com.hubertkulas.backendpatronage.service;

import com.hubertkulas.backendpatronage.dto.ConferenceRoomDto;

import java.util.List;


public interface ConferenceRoomService {

    List<ConferenceRoomDto> getAll();

    ConferenceRoomDto get(Long id);

    void add(ConferenceRoomDto conferenceRoomDto);

    void update(Long id, ConferenceRoomDto conferenceRoomDto);

    void delete(Long id);
}
