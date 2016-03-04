package com.robinpowered.sdk.model;

import com.google.common.base.Objects;

/**
 * Defines a users level of access with a {@link UserOrganization}.
 */
public class UserAccess {

    private final Integer managementLevel;
    private final Boolean isOwner;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserAccess that = (UserAccess) o;
        return Objects.equal(managementLevel, that.managementLevel) &&
                Objects.equal(isOwner, that.isOwner);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(managementLevel, isOwner);
    }

    @Override
    public String toString() {
        return "UserAccess{" +
                "managementLevel=" + managementLevel +
                ", isOwner=" + isOwner +
                "}";
    }
}
