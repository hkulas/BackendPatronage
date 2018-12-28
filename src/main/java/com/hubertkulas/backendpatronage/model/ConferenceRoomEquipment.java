package com.hubertkulas.backendpatronage.model;

import org.hibernate.validator.constraints.Range;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

@Entity
public class ConferenceRoomEquipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String projectorName;
    private boolean isTherePhone;

    @Range(min = 0, max = 100, message = "Minimal value of internal number should be 0 and maximum value should be 100")
    private int internalNumber;

    @Pattern(regexp = "(^\\+)[0-9]{2}\\s[0-9]{9}", message = "You should put your number in correct format like this: +12 123456789")
    private String externalNumber;

    private ConnectionType connectionType;

    public ConferenceRoomEquipment() {
    }

    public ConferenceRoomEquipment(String projectorName, boolean isTherePhone, int internalNumber, String externalNumber,ConnectionType connectionType) {
        this.projectorName = projectorName;
        this.isTherePhone = isTherePhone;
        this.connectionType = connectionType;

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

    public ConferenceRoomEquipment.ConnectionType getConnectionType() {
        return connectionType;
    }

    public void setConnectionType(ConferenceRoomEquipment.ConnectionType connectionType) {
        this.connectionType = connectionType;
    }

    public enum ConnectionType{
        Bluetooth,
        USB
    }
}
