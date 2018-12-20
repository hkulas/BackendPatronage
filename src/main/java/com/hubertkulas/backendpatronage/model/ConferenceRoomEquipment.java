package com.hubertkulas.backendpatronage.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ConferenceRoomEquipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String projectorName;
    private boolean isTherePhone;
    private int internalNumber;
    private String externalNumber;

    public ConferenceRoomEquipment() {
    }

    public ConferenceRoomEquipment(String projectorName, boolean isTherePhone, int internalNumber, String externalNumber) {
        this.projectorName = projectorName;
        this.isTherePhone = isTherePhone;

        if (isTherePhone) {
            this.internalNumber = internalNumber;
            this.externalNumber = externalNumber;
        }
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectorName() {
        return projectorName;
    }

    public void setProjectorName(String projectorName) {
        this.projectorName = projectorName;
    }

    public boolean isTherePhone() {
        return isTherePhone;
    }

    public void setTherePhone(boolean therePhone) {
        isTherePhone = therePhone;
    }

    public int getInternalNumber() {
        return internalNumber;
    }

    public void setInternalNumber(int internalNumber) {
        this.internalNumber = internalNumber;
    }

    public String getExternalNumber() {
        return externalNumber;
    }

    public void setExternalNumber(String externalNumber) {
        this.externalNumber = externalNumber;
    }
}
