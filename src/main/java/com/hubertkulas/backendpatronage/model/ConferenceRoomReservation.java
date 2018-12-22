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


    public ConferenceRoomReservation() {
    }

    public ConferenceRoomReservation(String personalId, LocalDateTime startOfReservation, LocalDateTime endOfReservation) {
        this.personalId = personalId;
        this.startOfReservation = startOfReservation;
        this.endOfReservation = endOfReservation;
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


}
