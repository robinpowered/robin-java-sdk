package com.robinpowered.sdk.model;

import java.util.List;

/**
 * An interface for Free-busy information returned for different models.
 */
public interface FreeBusy {

    /**
     * Returns a list of {@link Busy} intervals for which the given model is unavailable.
     *
     * @return A list of {@link Busy} intervals.
     */
    List<Busy> getBusy();

}
