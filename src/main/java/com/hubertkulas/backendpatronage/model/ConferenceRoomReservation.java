package com.hubertkulas.backendpatronage.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ConferenceRoomReservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String personalId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date startOfReservation;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date endOfReservation;

    private ConferenceRoom conferenceRoom;
    private ConferenceRoomEquipment conferenceRoomEquipment;
    private Organization organization;

    public ConferenceRoomReservation() {
    }

    public ConferenceRoomReservation(String personalId, Date startOfReservation, Date endOfReservation, ConferenceRoom conferenceRoom, ConferenceRoomEquipment conferenceRoomEquipment, Organization organization) {
        this.personalId = personalId;
        this.startOfReservation = startOfReservation;
        this.endOfReservation = endOfReservation;
        this.conferenceRoom = conferenceRoom;
        this.conferenceRoomEquipment = conferenceRoomEquipment;
        this.organization = organization;
    }

    public String getPersonalId() {
        return personalId;
    }

    public void setPersonalId(String personalId) {
        this.personalId = personalId;
    }

    public Date getStartOfReservation() {
        return startOfReservation;
    }

    public void setStartOfReservation(Date startOfReservation) {
        this.startOfReservation = startOfReservation;
    }

    public Date getEndOfReservation() {
        return endOfReservation;
    }

    public void setEndOfReservation(Date endOfReservation) {
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
