package com.robinpowered.sdk.model;

import java.util.List;

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

    public boolean isHasPresence() {
        return hasPresence;
    }

    public Space getSpace() {
        return space;
    }

    public List<Busy> getBusy() {
        return busy;
    }
}
