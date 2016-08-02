package com.robinpowered.sdk.model;

import com.google.gson.annotations.SerializedName;

import org.joda.time.DateTime;

/**
 * Interface for identifiers of {@link Device Devices}.
 */
public interface Identifier {

    /**
     * Robin identifier interface types
     */
    enum Interface {

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

    Urn getUrn();

    Interface getInterface();

    String getValue();

    DateTime getCreatedAt();
}
