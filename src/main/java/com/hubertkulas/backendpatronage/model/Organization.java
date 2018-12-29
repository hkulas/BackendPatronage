package com.hubertkulas.backendpatronage.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(unique = true)
    @Size(min = 2, max = 20, message = "The size of 'organization name' should be between 2 and 20")
    @NotBlank(message = "'organization name' should not be blank")
    private String organizationName;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "conference_room_id")
    private List<ConferenceRoom> conferenceRooms = new ArrayList<>();

    public Organization() {
    }

    public Organization(String organizationName,List<ConferenceRoom> conferenceRooms) {
        this.organizationName = organizationName;
        this.conferenceRooms = conferenceRooms;
    }

    public Organization(String organizationName) {
        this.organizationName = organizationName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public List<ConferenceRoom> getConferenceRooms() {
        return conferenceRooms;
    }

    public void setConferenceRooms(List<ConferenceRoom> conferenceRooms) {
        this.conferenceRooms = conferenceRooms;
    }
}
