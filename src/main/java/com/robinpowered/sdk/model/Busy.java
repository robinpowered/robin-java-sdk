package com.robinpowered.sdk.model;

import org.joda.time.DateTime;

import java.util.List;

public class Busy {

    /**
     * Constants
     */

    public static final String MIME_TYPE = "vnd.robinpowered.busy.v1";


    /**
     * Properties
     */

    private DateTime from;
    private DateTime to;
    private List<SimpleEvent> events;


    /**
     * Methods
     */

    public Busy(DateTime from, DateTime to, List<SimpleEvent> events) {
        this.from = from;
        this.to = to;
        this.events = events;
    }

    public static String getMimeType() {
        return MIME_TYPE;
    }

    public List<SimpleEvent> getSimpleEvents() {
        return events;
    }

    public DateTime getFrom() {
        return from;
    }

    public DateTime getTo() {
        return to;
    }
}
