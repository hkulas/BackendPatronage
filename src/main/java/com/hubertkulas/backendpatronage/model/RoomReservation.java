package com.hubertkulas.backendpatronage.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hubertkulas.backendpatronage.validator.UniquePersonalId;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;


@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class RoomReservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column(unique = true)
    @Size(min = 2, max =20, message = "The size of 'personal id' should be between 2 and 20")
    @NotBlank(message = "'personal id' should not be blank")
    @UniquePersonalId(message = "This personal id is already taken")
    private String personalId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime startOfReservation;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime endOfReservation;


    public RoomReservation() {
    }

    public RoomReservation(String personalId, LocalDateTime startOfReservation, LocalDateTime endOfReservation) {
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
