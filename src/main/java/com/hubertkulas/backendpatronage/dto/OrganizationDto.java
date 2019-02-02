package com.hubertkulas.backendpatronage.dto;

import com.hubertkulas.backendpatronage.model.Room;
import com.hubertkulas.backendpatronage.validator.UniqueOrganizationName;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

public class OrganizationDto {

    private Long id;

    @Size(min = 2, max = 20, message = "The size of 'organization name' should be between 2 and 20")
    @NotBlank(message = "'organization name' should not be blank")
    @UniqueOrganizationName(message = "This organization name is already taken")
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
