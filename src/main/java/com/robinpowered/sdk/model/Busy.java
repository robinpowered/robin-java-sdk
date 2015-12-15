package com.robinpowered.sdk.model;

import org.joda.time.DateTime;

import java.util.List;

/**
 * A period of time that a {@link Space} is unavailable for. <p>
 *
 * Contains a grouping of all events that occur within this unavailable block of time. When the
 * gap between events is shorter than the duration requested, the events will be grouped
 * together in a single Busy container.
 */
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

    /**
     * Constructor.
     *
     * @param from The start of the busy period.
     * @param to The end of the busy period.
     * @param events The {@link Event Events} occurring throughout the busy period.
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
