package com.robinpowered.sdk.model;

import com.google.common.base.Objects;
import com.google.gson.annotations.SerializedName;
import org.joda.time.DateTime;

/**
 * An invitee model, typically representing a person that has been invited to an {@link Event}. This
 * person may or may not be associated to an existing {@link User}.
 *
 * @todo This class needs further design once APIs are fully realized.
 */
public class Invitee implements IdentifiableApiResponseModel, Invited {

    /**
     * Constants
     */

    /**
     * The mime-type for this model.
     */
    public static final String MIME_TYPE = "vnd.robinpowered.invitee.v1";

    /**
     * The currently response status for the invitee.
     */
    public enum ResponseStatus {

        /**
         * The person's response is unknown or not yet set.
         */
        @SerializedName("none")
        NONE("none"),

        /**
         * The person has not responded to the event invite.
         */
        @SerializedName("not_responded")
        NOT_RESPONDED("not_responded"),

        /**
         * The person has declined the event invite.
         */
        @SerializedName("declined")
        DECLINED("declined"),

        /**
         * The person has tentatively accepted the event invite, but has not confirmed.
         */
        @SerializedName("tentative")
        TENTATIVE("tentative"),

        /**
         * The person has accepted the event invite.
         */
        @SerializedName("accepted")
        ACCEPTED("accepted");

        private final String value;

        public String getValue() {
            return value;
        }

        public static ResponseStatus fromString(String value) {
            return valueOf(value.toUpperCase());
        }

        ResponseStatus(String value) {
            this.value = value;
        }
    }


    /**
     * Properties
     */

    // Immutable
    private final int id;
    private final int eventId;

    // Mutable
    private Integer userId;
    private String email;
    private String displayName;
    private ResponseStatus responseStatus;
    private boolean isOrganizer;
    private boolean isResource;
    private DateTime updatedAt;
    private DateTime createdAt;

    // Submodels
    private User user;


    /**
     * Methods
     */

    public Invitee(int id, int eventId) {
        this.id = id;
        this.eventId = eventId;
    }

    @Override
    public int getId() {
        return id;
    }

    public Integer getEventId() {
        return eventId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

    public boolean isOrganizer() {
        return isOrganizer;
    }

    public void setIsOrganizer(boolean isOrganizer) {
        this.isOrganizer = isOrganizer;
    }

    public boolean isResource() {
        return isResource;
    }

    public void setIsResource(boolean isResource) {
        this.isResource = isResource;
    }

    public DateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(DateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public DateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(DateTime createdAt) {
        this.createdAt = createdAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invitee invitee = (Invitee) o;
        return Objects.equal(id, invitee.id) &&
                Objects.equal(eventId, invitee.eventId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, eventId);
    }

    @Override
    public String toString() {
        return "Invitee{" +
                "id=" + id +
                ", eventId=" + eventId +
                ", userId=" + userId +
                ", email='" + email + '\'' +
                ", displayName='" + displayName + '\'' +
                ", responseStatus=" + responseStatus +
                ", isOrganizer=" + isOrganizer +
                ", isResource=" + isResource +
                ", updatedAt=" + updatedAt +
                ", createdAt=" + createdAt +
                ", user=" + user +
                '}';
    }

    @Override
    public String getMimeType() {
        return MIME_TYPE;
    }

    /**
     * Used to invite others to an {@link Event} or {@link Event.Booking} and to become and {@link Invitee}.
     */
    public static class Invitation implements Invited {

        private final String email;

        public Invitation(String email) {
            this.email = email;
        }

        public String getEmail() {
            return email;
        }
    }
}
