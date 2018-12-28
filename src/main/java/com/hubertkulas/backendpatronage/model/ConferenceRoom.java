package com.hubertkulas.backendpatronage.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ConferenceRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @Size(min = 2, max =20, message = "The size of 'room name' should be between 2 and 20")
    @NotBlank(message = "'room name' should not be blank")
    private String roomName;

    @Column(unique = true)
    @Size(min = 2, max =20, message = "The size of 'id of room' should be between 2 and 20")
    @NotBlank(message = "'id of room' should not be blank")
    private String idOfRoom;

    @Range(min = 0, max =10, message = "Minimal value of floor should be 0 and maximum value should be 10")
    private int floor;


    private boolean isAvailable;

    private int standingPlaces;
    private int seats;
    private int hangingPlaces;

    @ManyToOne(cascade = CascadeType.ALL)
    private ConferenceRoomEquipment conferenceRoomEquipment;


    public ConferenceRoom() {
    }

    public ConferenceRoom(String roomName, String idOfRoom, int floor, boolean isAvailable, int standingPlaces, int seats, int hangingPlaces, ConferenceRoomEquipment conferenceRoomEquipment) {
        this.roomName = roomName;
        this.idOfRoom = idOfRoom;
        this.floor = floor;
        this.isAvailable = isAvailable;
        this.standingPlaces = standingPlaces;
        this.seats = seats;
        this.hangingPlaces = hangingPlaces;
        this.conferenceRoomEquipment = conferenceRoomEquipment;
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

    public void setAvailable(boolean isAvailable) {
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

    public ConferenceRoomEquipment getConferenceRoomEquipment() {
        return conferenceRoomEquipment;
    }

    public void setConferenceRoomEquipment(ConferenceRoomEquipment conferenceRoomEquipment) {
        this.conferenceRoomEquipment = conferenceRoomEquipment;
    }
}
