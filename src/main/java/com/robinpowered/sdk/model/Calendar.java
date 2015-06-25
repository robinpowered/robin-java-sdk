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

    private final Integer spaceId;
    private final String remoteType;
    private final String calendarId;
    private final String subscriberId;
    private final String spaceResourceId;
    private final String spaceResourceEmail;
    private final DateTime subscriberExpiresAt;
    private final DateTime createdAt;


    /**
     * Methods
     */

    public Calendar(Integer spaceId, String remoteType, String calendarId, String subscriberId, String spaceResourceId,
                    String spaceResourceEmail, DateTime subscriberExpiresAt, DateTime createdAt) {

        this.spaceId = spaceId;
        this.remoteType = remoteType;
        this.calendarId = calendarId;
        this.subscriberId = subscriberId;
        this.spaceResourceId = spaceResourceId;
        this.spaceResourceEmail = spaceResourceEmail;
        this.subscriberExpiresAt = subscriberExpiresAt;
        this.createdAt = createdAt;
    }

    public Integer getSpaceId() {
        return spaceId;
    }

    public String getRemoteType() {
        return remoteType;
    }

    public String getCalendarId() {
        return calendarId;
    }

    public String getSpaceResourceId() {
        return spaceResourceId;
    }

    public String getSpaceResourceEmail() {
        return spaceResourceEmail;
    }

    public String getSubscriberId() {
        return subscriberId;
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
                Objects.equal(createdAt, calendar.createdAt) &&
                Objects.equal(remoteType, calendar.remoteType) &&
                Objects.equal(calendarId, calendar.calendarId) &&
                Objects.equal(subscriberId, calendar.subscriberId) &&
                Objects.equal(spaceResourceId, calendar.spaceResourceId) &&
                Objects.equal(spaceResourceEmail, calendar.spaceResourceEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(spaceId, createdAt, remoteType, calendarId, subscriberId, spaceResourceId, spaceResourceEmail);
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
