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
 * {@link com.robinpowered.sdk.model.Identifier.Interface Interfaces}.
 *
 * @see com.robinpowered.sdk.model.Identifier.Interface
 */
public class Identifier implements ApiResponseModel {

    /**
     * Constants
     */

    public static final String MIME_TYPE = "vnd.robinpowered.identifier.v1";

    /**
     * Robin identifier interface types
     */
    public enum Interface {

        @SerializedName("ble")
        BLE("ble"),

        @SerializedName("rfid")
        RFID("rfid"),

        @SerializedName("robin-uuid")
        ROBIN_UUID("robin-uuid"),

        @SerializedName("robin-ibeacon")
        ROBIN_IBEACON("robin-ibeacon"),

        @SerializedName("arduino")
        ARDUINO("arduino"),

        @SerializedName("relay")
        RELAY("relay");

        private final String value;

        public String getValue() {
            return value;
        }

        public static Interface fromString(String value) {
            return valueOf(value.toUpperCase().replace('-', '_'));
        }

        Interface(String value) {
            this.value = value;
        }
    }


    /**
     * Properties
     */

    // Immutable
    private final Urn urn;
    @SerializedName("interface")
    private final Interface idInterface; // Use a non-Java-keyword for our field name
    private final String value;

    // Mutable
    private DateTime createdAt;


    /**
     * Methods
     */

    public Identifier(Urn urn, Interface idInterface, String value) {
        this.urn = urn;
        this.idInterface = idInterface;
        this.value = value;
    }

    public Urn getUrn() {
        return urn;
    }

    public Interface getInterface() {
        return idInterface;
    }

    public String getValue() {
        return value;
    }

    public DateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(DateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Identifier that = (Identifier) o;
        return Objects.equal(urn, that.urn) &&
                Objects.equal(idInterface, that.idInterface) &&
                Objects.equal(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(urn, idInterface, value);
    }

    @Override
    public String toString() {
        return "Identifier{" +
                "urn=" + urn +
                ", idInterface=" + idInterface +
                ", value='" + value + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }

    @Override
    public String getMimeType() {
        return MIME_TYPE;
    }

    public static class CreationRequest {

        private Interface identifierInterface;
        private Urn urn;

        public CreationRequest(Interface identifierInterface, Urn urn) {
            this.identifierInterface = identifierInterface;
            this.urn = urn;
        }
    }
}
