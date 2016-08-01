package com.robinpowered.sdk.model;

import com.google.gson.annotations.SerializedName;

import org.joda.time.DateTime;

/**
 * A model that represents an abstract means of identifying an iBeacon {@link Device}.
 */
public class IbeaconIdentifier implements Identifier {

    private final Urn urn;
    @SerializedName("interface")
    private final Interface type; // Use a non-Java-keyword for our field name
    private final String value;
    private final DateTime createdAt;
    private final Integer deviceId;
    private final Integer major;
    private final Integer minor;
    private final String uuid;

    public IbeaconIdentifier(Urn urn, Interface type, String value, DateTime createdAt,
                             Integer deviceId, Integer major, Integer minor, String uuid) {
        this.urn = urn;
        this.type = type;
        this.value = value;
        this.createdAt = createdAt;
        this.deviceId = deviceId;
        this.major = major;
        this.minor = minor;
        this.uuid = uuid;
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

    public Integer getDeviceId() {
        return deviceId;
    }

    public Integer getMajor() {
        return major;
    }

    public Integer getMinor() {
        return minor;
    }

    public String getUuid() {
        return uuid;
    }
}
