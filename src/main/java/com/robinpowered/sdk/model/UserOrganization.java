package com.robinpowered.sdk.model;

import org.joda.time.DateTime;

/**
 * An {@link Organization} containing {@link UserAccess} data.
 */
public class UserOrganization extends Organization {

    /**
     * Constants
     */

    public static final String MIME_TYPE = "vnd.robinpowered.user-organization.v1";


    /**
     * Properties
     */

    private UserAccess userAccess;


    /**
     * Methods
     */

    public UserOrganization(int id, String slug, boolean isOrganization, DateTime createdAt, DateTime updatedAt,
                            UserAccess userAccess) {
        super(id, slug, isOrganization, createdAt, updatedAt);

        this.userAccess = userAccess;
    }

    @Override
    public String getMimeType() {
        return MIME_TYPE;
    }

    @Override
    public String toString() {
        return super.toString() + " " + userAccess.toString();
    }

    public UserAccess getUserAccess() {
        return userAccess;
    }
}
