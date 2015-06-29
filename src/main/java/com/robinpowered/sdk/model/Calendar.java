package com.robinpowered.sdk.model;

import com.google.common.base.Objects;
import org.joda.time.DateTime;

/**
 * A calendar that is associated to a {@link Space}, where the {@link Event Events} live remotely.
 *
 * <p>
 * When Events are booked within a space, the change will also be reflected on the
 * calendar. When events are manually added to a Google or Microsoft calendar, then will
 * automatically be synced to the space.
 *
 * <p>
 * Spaces without calendars are considered "breakout" spaces are not able to be reserved.
 */
public class Calendar implements ApiResponseModel {

    /**
     * Constants
     */

    public static final String MIME_TYPE = "vnd.robinpowered.calendar.v1";


    /**
     * Properties
     */

    // Immutable
    private final Integer spaceId;
    private final DateTime subscriberExpiresAt;
    private final DateTime createdAt;

    // Mutable
    private String remoteType;
    private String calendarId;
    private String subscriberId;
    private String spaceResourceId;
    private String spaceResourceEmail;


    /**
     * Methods
     */

    public Calendar(Integer spaceId, DateTime subscriberExpiresAt, DateTime createdAt) {
        this.spaceId = spaceId;
        this.subscriberExpiresAt = subscriberExpiresAt;
        this.createdAt = createdAt;
    }

    public Integer getSpaceId() {
        return spaceId;
    }

    public String getRemoteType() {
        return remoteType;
    }

    public void setRemoteType(String remoteType) {
        this.remoteType = remoteType;
    }

    public String getCalendarId() {
        return calendarId;
    }

    public void setCalendarId(String calendarId) {
        this.calendarId = calendarId;
    }

    public String getSpaceResourceId() {
        return spaceResourceId;
    }

    public void setSpaceResourceId(String spaceResourceId) {
        this.spaceResourceId = spaceResourceId;
    }

    public String getSpaceResourceEmail() {
        return spaceResourceEmail;
    }

    public void setSpaceResourceEmail(String spaceResourceEmail) {
        this.spaceResourceEmail = spaceResourceEmail;
    }

    public String getSubscriberId() {
        return subscriberId;
    }

    public void setSubscriberId(String subscriberId) {
        this.subscriberId = subscriberId;
    }

    public DateTime getSubscriberExpiresAt() {
        return subscriberExpiresAt;
    }

    public DateTime getCreatedAt() {
        return createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Calendar calendar = (Calendar) o;
        return Objects.equal(spaceId, calendar.spaceId) &&
                Objects.equal(subscriberExpiresAt, calendar.subscriberExpiresAt) &&
                Objects.equal(createdAt, calendar.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(spaceId, subscriberExpiresAt, createdAt);
    }

    @Override
    public String toString() {
        return "Calendar{" +
                "spaceId=" + spaceId +
                ", remoteType='" + remoteType + '\'' +
                ", calendarId='" + calendarId + '\'' +
                ", subscriberId='" + subscriberId + '\'' +
                ", spaceResourceId='" + spaceResourceId + '\'' +
                ", spaceResourceEmail='" + spaceResourceEmail + '\'' +
                ", subscriberExpiresAt=" + subscriberExpiresAt +
                ", createdAt=" + createdAt +
                '}';
    }

    @Override
    public String getMimeType() {
        return MIME_TYPE;
    }
}
