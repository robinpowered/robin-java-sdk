package com.robinpowered.sdk.model;

import java.io.Serializable;

/**
 * An interface that should be implemented by all models that represent remote API models.
 */
public interface ApiResponseModel extends Serializable {

    /**
     * Returns the mime type for the model.
     *
     * @return The mime type.
     */
    String getMimeType();
}
