package com.hubertkulas.backendpatronage.model;

public class ConferenceRoom {
    private String name;
    private String idOfRoom;
    private int floor;
    private boolean isItAvailable;
    private int standingPlaces;
    private int seats;
    private int hangingPlaces;

    public ConferenceRoom() {
    }

    public ConferenceRoom(String name, String idOfRoom, int floor, boolean isItAvailable, int standingPlaces, int seats, int hangingPlaces) {
        this.name = name;
        this.idOfRoom = idOfRoom;
        this.floor = floor;
        this.isItAvailable = isItAvailable;
        this.standingPlaces = standingPlaces;
        this.seats = seats;
        this.hangingPlaces = hangingPlaces;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public boolean isItAvailable() {
        return isItAvailable;
    }

    public void setItAvailable(boolean itAvailable) {
        isItAvailable = itAvailable;
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
}
