package com.hubertkulas.backendpatronage.dto;

import com.hubertkulas.backendpatronage.model.RoomEquipment;

public class RoomDto {

    private Long id;
    private String roomName;
    private String idOfRoom;
    private int floor;
    private boolean isAvailable;
    private int standingPlaces;
    private int seats;
    private int hangingPlaces;
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

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public int getStandingPlaces() {
        return standingPlaces;
    }

    public void setStandingPlaces(int standingPlaces) {
        this.standingPlaces = standingPlaces;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int getHangingPlaces() {
        return hangingPlaces;
    }

    public void setHangingPlaces(int hangingPlaces) {
        this.hangingPlaces = hangingPlaces;
    }

    public RoomEquipment getRoomEquipment() {
        return roomEquipment;
    }

    public void setRoomEquipment(RoomEquipment roomEquipment) {
        this.roomEquipment = roomEquipment;
    }
}
