package com.hubertkulas.backendpatronage.dto;

import com.hubertkulas.backendpatronage.model.Room;

import java.util.ArrayList;
import java.util.List;

public class OrganizationDto {

    private Long id;
    private String organizationName;
    private List<Room> rooms = new ArrayList<>();

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

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
}
