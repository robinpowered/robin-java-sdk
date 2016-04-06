package com.robinpowered.sdk.model;

/**
 * An interface to be implemented by models that contain an {@code id} attribute.
 */
public interface IdentifiableApiResponseModel<IdType> extends ApiResponseModel {
    IdType getId();
}
