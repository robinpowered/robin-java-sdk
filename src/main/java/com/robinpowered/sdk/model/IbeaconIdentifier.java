package com.robinpowered.sdk.model;

import com.google.common.base.Objects;
import com.google.gson.annotations.SerializedName;

import org.joda.time.DateTime;

/**
 * A model that represents an abstract means of identifying an iBeacon {@link Device}.
 */
public class IbeaconIdentifier implements ApiResponseModel, Identifier {

    public static final String MIME_TYPE = "vnd.robinpowered.identifier.ibeacon.v1";

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IbeaconIdentifier that = (IbeaconIdentifier) o;
        return Objects.equal(urn, that.urn) &&
                Objects.equal(type, that.type) &&
                Objects.equal(value, that.value) &&
                Objects.equal(createdAt, that.createdAt) &&
                Objects.equal(deviceId, that.deviceId) &&
                Objects.equal(major, that.major) &&
                Objects.equal(minor, that.minor) &&
                Objects.equal(uuid, that.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(urn, type, value, createdAt, deviceId, major, minor, uuid);
    }

    @Override
    public String toString() {
        return "BasicIdentifier{" +
                "urn=" + urn +
                ", type=" + type +
                ", value='" + value + '\'' +
                ", createdAt=" + createdAt +
                ", deviceId=" + deviceId +
                ", major=" + major +
                ", minor=" + minor +
                ", uuid=" + uuid +
                '}';
    }

    @Override
    public String getMimeType() {
        return MIME_TYPE;
    }
}
