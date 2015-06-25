package com.robinpowered.sdk.model;

/**
 * A company or team. Made up of users, locations and spaces.
 */
public class Organization extends Account implements IdentifiableApiResponseModel {

    /**
     * Constants
     */

    public static final String MIME_TYPE = "vnd.robinpowered.organization.v1";


    /**
     * Methods
     */

    public Organization(int id, String slug) {
        super(id, slug);
    }

    @Override
    public String getMimeType() {
        return MIME_TYPE;
    }

    @Override
    public String toString() {
        return "Organization{} " + super.toString();
    }
}
