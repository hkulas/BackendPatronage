package com.hubertkulas.backendpatronage.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;


@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ConferenceRoomReservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String personalId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private Date startOfReservation;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private Date endOfReservation;

    @ManyToOne(cascade = CascadeType.ALL)
    private ConferenceRoom conferenceRoom;

    @ManyToOne(cascade = CascadeType.ALL)
    private ConferenceRoomEquipment conferenceRoomEquipment;

    @ManyToOne(cascade = CascadeType.ALL)
    private Organization organization;

    public ConferenceRoomReservation() {
    }

    public ConferenceRoomReservation(String personalId, Date startOfReservation, Date endOfReservation, ConferenceRoom conferenceRoom,
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
