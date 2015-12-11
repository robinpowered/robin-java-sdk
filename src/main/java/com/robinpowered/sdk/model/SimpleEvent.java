package com.robinpowered.sdk.model;

import com.google.common.base.Objects;

import org.joda.time.DateTime;

/**
 * A simplified {@link Event}.
 *
 * <p>
 * A simplified version of an event containing start and end times, as well as a matching ID for
 * referencing the associated {@link Event}.
 */
public class SimpleEvent implements ApiResponseModel {

    /**
     * Constants
     */

    public static final String MIME_TYPE = "vnd.robinpowered.simple-event.v1";


    /**
     * Properties
     */

    private int id;
    private DateTime startedAt;
    private DateTime endedAt;


    /**
     * Methods
     */

    /**
     * Constructs a SimpleEvent.
     *
     * @param id The id of the event.
     * @param startedAt When the event started.
     * @param endedAt When the event ended.
     */
    public SimpleEvent(int id, DateTime startedAt, DateTime endedAt) {
        this.id = id;
        this.startedAt = startedAt;
        this.endedAt = endedAt;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (that == null || !(that instanceof SimpleEvent)) return false;
        return Objects.equal(id, ((SimpleEvent) that).id);
    }

    @Override
    public String getMimeType() {
        return MIME_TYPE;
    }

    public int getId() {
        return id;
    }

    public DateTime getStartedAt() {
        return startedAt;
    }

    public DateTime getEndedAt() {
        return endedAt;
    }
}
