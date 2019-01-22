package com.hubertkulas.backendpatronage.dto;

import com.hubertkulas.backendpatronage.model.RoomEquipment;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class RoomDto {

    private Long id;
    @Size(min = 2, max = 20, message = "The size of 'room name' should be between 2 and 20")
    @NotBlank(message = "'room name' should not be blank")
    private String roomName;
    @Size(min = 2, max = 20, message = "The size of 'id of room' should be between 2 and 20")
    @NotBlank(message = "'id of room' should not be blank")
    private String idOfRoom;
    @Range(min = 0, max = 10, message = "Minimal value of floor should be 0 and maximum value should be 10")
    private Integer floor;
    private Boolean available;
    private Integer standingPlaces;
    private Integer seats;
    private Integer hangingPlaces;
    private RoomEquipment roomEquipment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getIdOfRoom() {
        return idOfRoom;
    }

    public void setIdOfRoom(String idOfRoom) {
        this.idOfRoom = idOfRoom;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public Integer getStandingPlaces() {
        return standingPlaces;
    }

    public void setStandingPlaces(Integer standingPlaces) {
        this.standingPlaces = standingPlaces;
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    public Integer getHangingPlaces() {
        return hangingPlaces;
    }

    public void setHangingPlaces(Integer hangingPlaces) {
        this.hangingPlaces = hangingPlaces;
    }

    public RoomEquipment getRoomEquipment() {
        return roomEquipment;
    }

    public void setRoomEquipment(RoomEquipment roomEquipment) {
        this.roomEquipment = roomEquipment;
    }
}
