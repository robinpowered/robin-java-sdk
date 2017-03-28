package com.robinpowered.sdk.model;

import org.joda.time.DateTime;

/**
 * Represents the check-in/confirmation of an {@link Event}.
 */
public class Confirmation {

    public static final String MIME_TYPE = "vnd.robinpowered.confirmation.v1";

    private String eventId;
    private Integer user_id;
    private Integer device_id;
    private DateTime confirmedAt;

    public Confirmation(String eventId, Integer user_id, Integer device_id, DateTime confirmedAt) {
        this.eventId = eventId;
        this.user_id = user_id;
        this.device_id = device_id;
        this.confirmedAt = confirmedAt;
    }

    public String getEventId() {
        return eventId;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public Integer getDevice_id() {
        return device_id;
    }

    public DateTime getConfirmedAt() {
        return confirmedAt;
    }
}
