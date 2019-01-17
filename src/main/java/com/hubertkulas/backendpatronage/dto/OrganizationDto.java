package com.hubertkulas.backendpatronage.dto;

import com.hubertkulas.backendpatronage.model.ConferenceRoom;

import java.util.ArrayList;
import java.util.List;

public class OrganizationDto {

    private Long id;
    private String organizationName;
    private List<ConferenceRoom> conferenceRooms = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public List<ConferenceRoom> getConferenceRooms() {
        return conferenceRooms;
    }

    public void setConferenceRooms(List<ConferenceRoom> conferenceRooms) {
        this.conferenceRooms = conferenceRooms;
    }
}
