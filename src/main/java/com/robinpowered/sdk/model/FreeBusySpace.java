package com.robinpowered.sdk.model;

import java.util.List;

/**
 * Free-busy information returned for a given {@link Space} across a requested period of time. <p>
 *
 * Free-busy information describes the availability of a {@link Space} throughout a period of time
 * by returning a set of {@link Busy} intervals which contain all events which overlap the requested
 * period of time. The given space is available for the requested duration during any gaps between
 * {@link Busy} models.
 */
public class FreeBusySpace implements ApiResponseModel, FreeBusy {

    /**
     * Constants
     */

    public static final String MIME_TYPE = "vnd.robinpowered.free-busy-space.v1";


    /**
     * Properties
     */

    private boolean hasPresence;
    private Space space;
    private List<Busy> busy;


    /**
     * Methods
     */

    public FreeBusySpace(boolean hasPresence, Space space, List<Busy> busy) {
        this.hasPresence = hasPresence;
        this.space = space;
        this.busy = busy;
    }

    @Override
    public String getMimeType() {
        return MIME_TYPE;
    }

    public boolean hasPresence() {
        return hasPresence;
    }

    public Space getSpace() {
        return space;
    }

    public List<Busy> getBusy() {
        return busy;
    }
}
