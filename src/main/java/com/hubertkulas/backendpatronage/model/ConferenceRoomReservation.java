package com.hubertkulas.backendpatronage.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ConferenceRoomReservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String personalId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime startOfReservation;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime endOfReservation;

    @ManyToOne(cascade = CascadeType.ALL)
    private ConferenceRoom conferenceRoom;

    @ManyToOne(cascade = CascadeType.ALL)
    private ConferenceRoomEquipment conferenceRoomEquipment;

    @ManyToOne(cascade = CascadeType.ALL)
    private Organization organization;

    public ConferenceRoomReservation() {
    }

    public ConferenceRoomReservation(String personalId, LocalDateTime startOfReservation, LocalDateTime endOfReservation, ConferenceRoom conferenceRoom,
                                     ConferenceRoomEquipment conferenceRoomEquipment, Organization organization) {
        this.personalId = personalId;
        this.startOfReservation = startOfReservation;
        this.endOfReservation = endOfReservation;
        this.conferenceRoom = conferenceRoom;
        this.conferenceRoomEquipment = conferenceRoomEquipment;
        this.organization = organization;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public String getPersonalId() {
        return personalId;
    }

    public void setPersonalId(String personalId) {
        this.personalId = personalId;
    }

    public LocalDateTime getStartOfReservation() {
        return startOfReservation;
    }

    public void setStartOfReservation(LocalDateTime startOfReservation) {
        this.startOfReservation = startOfReservation;
    }

    public LocalDateTime getEndOfReservation() {
        return endOfReservation;
    }

    public void setEndOfReservation(LocalDateTime endOfReservation) {
        this.endOfReservation = endOfReservation;
    }


    public ConferenceRoom getConferenceRoom() {
        return conferenceRoom;
    }

    public void setConferenceRoom(ConferenceRoom conferenceRoom) {
        this.conferenceRoom = conferenceRoom;
    }

    public ConferenceRoomEquipment getConferenceRoomEquipment() {
        return conferenceRoomEquipment;
    }

    public void setConferenceRoomEquipment(ConferenceRoomEquipment conferenceRoomEquipment) {
        this.conferenceRoomEquipment = conferenceRoomEquipment;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }
}
