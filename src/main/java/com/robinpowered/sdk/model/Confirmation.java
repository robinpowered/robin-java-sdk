package com.robinpowered.sdk.model;

import com.google.common.base.Objects;
import org.joda.time.DateTime;

/**
 * Represents the check-in/confirmation of an {@link Event}.
 */
public class Confirmation {

    public static final String MIME_TYPE = "vnd.robinpowered.confirmation.v1";

    private final String eventId;
    private final Integer userId;
    private final Integer deviceId;
    private final DateTime confirmedAt;

    public Confirmation(String eventId, Integer userId, Integer deviceId, DateTime confirmedAt) {
        this.eventId = eventId;
        this.userId = userId;
        this.deviceId = deviceId;
        this.confirmedAt = confirmedAt;
    }

    public String getEventId() {
        return eventId;
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public DateTime getConfirmedAt() {
        return confirmedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Confirmation that = (Confirmation) o;
        return Objects.equal(eventId, that.eventId) &&
                Objects.equal(userId, that.userId) &&
                Objects.equal(deviceId, that.deviceId) &&
                Objects.equal(confirmedAt, that.confirmedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(eventId, userId, deviceId, confirmedAt);
    }
}
