package com.robinpowered.sdk.model;

import com.google.common.base.Objects;
import com.google.gson.annotations.SerializedName;
import org.joda.time.DateTime;

/**
 * A model that represents an abstract means of identifying a {@link Device}.
 *
 * <p>
 * Devices often have defining characteristics such as a mac address or UUID. This class provides
 * a way of defining and manipulating the supported types of identification
 * {@link BasicIdentifier.Interface Interfaces}.
 *
 * @see BasicIdentifier.Interface
 */
public class BasicIdentifier implements ApiResponseModel, Identifier {

    public static final String MIME_TYPE = "vnd.robinpowered.identifier.v1";

    // Immutable
    private final Urn urn;
    @SerializedName("interface")
    private final Interface type; // Use a non-Java-keyword for our field name
    private final String value;
    private final DateTime createdAt;

    public BasicIdentifier(Urn urn, Interface type, String value, DateTime createdAt) {
        this.urn = urn;
        this.type = type;
        this.value = value;
        this.createdAt = createdAt;
    }

    public Urn getUrn() {
        return urn;
    }

    public Interface getInterface() {
        return type;
    }

    public String getValue() {
        return value;
    }

    public DateTime getCreatedAt() {
        return createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BasicIdentifier that = (BasicIdentifier) o;
        return Objects.equal(urn, that.urn) &&
                Objects.equal(type, that.type) &&
                Objects.equal(value, that.value) &&
                Objects.equal(createdAt, that.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(urn, type, value, createdAt);
    }

    @Override
    public String toString() {
        return "BasicIdentifier{" +
                "urn=" + urn +
                ", type=" + type +
                ", value='" + value + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }

    @Override
    public String getMimeType() {
        return MIME_TYPE;
    }
}
