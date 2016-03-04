package com.robinpowered.sdk.model;

import com.google.common.base.Objects;
import org.joda.time.DateTime;

/**
 * An {@link Organization} entity that represents a user's membership, containing the {@link UserAccess} model.
 */
public class UserOrganization extends Organization {

    /**
     * Constants
     */

    public static final String MIME_TYPE = "vnd.robinpowered.user-organization.v1";


    /**
     * Properties
     */

    private final UserAccess userAccess;


    /**
     * Methods
     */

    public UserOrganization(int id, String slug, boolean isOrganization, DateTime createdAt, DateTime updatedAt,
                            UserAccess userAccess) {
        super(id, slug, isOrganization, createdAt, updatedAt);

        this.userAccess = userAccess;
    }

    public UserAccess getUserAccess() {
        return userAccess;
    }

    @Override
    public String getMimeType() {
        return MIME_TYPE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        UserOrganization that = (UserOrganization) o;
        return Objects.equal(userAccess, that.userAccess);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), userAccess);
    }

    @Override
    public String toString() {
        return super.toString() + " " + userAccess.toString();
    }
}
