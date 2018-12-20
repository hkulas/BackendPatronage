package com.hubertkulas.backendpatronage.model;

import javax.persistence.*;

@Entity
public class ConferenceRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roomName;
    private String idOfRoom;
    private int floor;
    private boolean isAvailable;
    private int standingPlaces;
    private int seats;
    private int hangingPlaces;

    public ConferenceRoom() {
    }

    public ConferenceRoom(String roomName, String idOfRoom, int floor, boolean isAvailable, int standingPlaces, int seats, int hangingPlaces) {
        this.roomName = roomName;
        this.idOfRoom = idOfRoom;
        this.floor = floor;
        this.isAvailable = isAvailable;
        this.standingPlaces = standingPlaces;
        this.seats = seats;
        this.hangingPlaces = hangingPlaces;

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

    public void setisItAvailable(boolean itAvailable) {
        isAvailable = isAvailable;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
