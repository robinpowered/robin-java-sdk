package com.robinpowered.sdk.model;

import com.google.common.base.Objects;

/**
 * A user model.
 */
public class User extends Account implements IdentifiableApiResponseModel {

    /**
     * Constants
     */

    public static final String MIME_TYPE = "vnd.robinpowered.user.v1";


    /**
     * Properties
     */

    private Email primaryEmail;
    private Boolean isPending;


    /**
     * Methods
     */

    public User(int id, String slug) {
        super(id, slug);
    }

    public Email getPrimaryEmail() {
        return primaryEmail;
    }

    public void setPrimaryEmail(Email primaryEmail) {
        this.primaryEmail = primaryEmail;
    }

    public Boolean isPending() {
        return isPending;
    }

    public void setIsPending(Boolean isPending) {
        this.isPending = isPending;
    }

    @Override
    public String toString() {
        return "User{" +
                "primaryEmail=" + primaryEmail +
                ", isPending=" + isPending +
                "} " + super.toString();
    }

    @Override
    public String getMimeType() {
        return MIME_TYPE;
    }

    /**
     * An email address belonging to a user.
     */
    public static class Email implements ApiResponseModel {

        /**
         * Constants
         */

        public static final String MIME_TYPE = "vnd.robinpowered.email.v1";


        /**
         * Properties
         */

        // Immutable
        private final String email;

        // Mutable
        private Boolean isVerified;

        /**
         * Methods
         */

        public Email(String email) {
            this.email = email;
        }

        public String getEmail() {
            return email;
        }

        public Boolean isVerified() {
            return isVerified;
        }

        public void setIsVerified(Boolean isVerified) {
            this.isVerified = isVerified;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Email email1 = (Email) o;
            return Objects.equal(email, email1.email);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(email);
        }

        @Override
        public String toString() {
            return email;
        }

        @Override
        public String getMimeType() {
            return Email.MIME_TYPE;
        }
    }
}
