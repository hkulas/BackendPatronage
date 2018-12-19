package com.hubertkulas.backendpatronage.model;

public class ConferenceRoomEquipment {

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
