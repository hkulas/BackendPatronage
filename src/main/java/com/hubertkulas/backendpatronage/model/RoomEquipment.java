package com.hubertkulas.backendpatronage.model;

import org.hibernate.validator.constraints.Range;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

@Entity
public class RoomEquipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String projectorName;
    private boolean isTherePhone;

    @Range(min = 0, max = 100, message = "Minimal value of internal number should be 0 and maximum value should be 100")
    private Integer internalNumber ;

    @Pattern(regexp = "(^\\+)[0-9]{2}\\s[0-9]{9}", message = "You should put your number in correct format like this: +12 123456789")
    private String externalNumber;

    private ConnectionType connectionType;

    public RoomEquipment() {
    }

    public RoomEquipment(String projectorName, boolean isTherePhone, Integer internalNumber,String externalNumber, ConnectionType connectionType) {
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

    public Integer getInternalNumber() {
        return internalNumber;
    }

    public void setInternalNumber(Integer internalNumber) {
        this.internalNumber = internalNumber;
    }

    public String getExternalNumber() {
        return externalNumber;
    }

    public void setExternalNumber(String externalNumber) {
        this.externalNumber = externalNumber;
    }

    public ConnectionType getConnectionType() {
        return connectionType;
    }

    public void setConnectionType(ConnectionType connectionType) {
        this.connectionType = connectionType;
    }

    public enum ConnectionType{
        Bluetooth,
        USB
    }
}
