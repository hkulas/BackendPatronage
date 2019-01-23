package com.hubertkulas.backendpatronage.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class RoomReservationDto {

    private Long id;

    @Size(min = 2, max =20, message = "The size of 'personal id' should be between 2 and 20")
    @NotBlank(message = "'personal id' should not be blank")
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
