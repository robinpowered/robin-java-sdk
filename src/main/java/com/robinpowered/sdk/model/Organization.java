package com.robinpowered.sdk.model;

import org.joda.time.DateTime;

/**
 * A company or team. Made up of users, locations and spaces.
 *
 * @todo should isOrganization be exposed in this model?
 */
public class Organization extends Account implements IdentifiableApiResponseModel {

    /**
     * Constants
     */

    public static final String MIME_TYPE = "vnd.robinpowered.organization.v1";


    /**
     * Methods
     */

    public Organization(int id, String slug, boolean isOrganization, DateTime createdAt, DateTime updatedAt) {
        super(id, slug, isOrganization, createdAt, updatedAt);
    }

    @Override
    public String getMimeType() {
        return MIME_TYPE;
    }

    @Override
    public String toString() {
        return "Organization{} " + super.toString();
    }

    public static final class Reference extends Account.Reference {
        public Reference(String slug) {
            super(slug);
        }

        public Reference(int organizationId) {
            super(organizationId);
        }
    }
}
