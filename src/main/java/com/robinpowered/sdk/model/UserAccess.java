package com.robinpowered.sdk.model;

public class UserAccess {

    private Integer managementLevel;
    private Boolean isOwner;

    public UserAccess(Integer managementLevel, Boolean isOwner) {
        this.managementLevel = managementLevel;
        this.isOwner = isOwner;
    }

    public int getManagementLevel() {
        return managementLevel;
    }

    public Boolean getOwner() {
        return isOwner;
    }
}
