package com.hubertkulas.backendpatronage.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class ConferenceRoomReservationDto {

    private Long id;

    private String personalId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime startOfReservation;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime endOfReservation;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
