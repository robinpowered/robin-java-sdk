package com.robinpowered.sdk.model;

import com.google.common.base.Objects;
import org.joda.time.DateTime;

import java.util.List;

/**
 * A piece of hardware that may exist in a space.
 *
 * <p>
 * Devices can report such as temperature or presence, but may also expose features that may be
 * controlled, such as AV hardware or a thermostat. Common devices include beacons, phones, and
 * motion sensors.
 */
public class Device implements IdentifiableApiResponseModel<Integer> {

    /**
     * Constants
     */

    public static final String MIME_TYPE = "vnd.robinpowered.device.v1";


    /**
     * Properties
     */

    // Immutable
    private final int id;
    private final int accountId;
    private final Integer deviceManifestId;
    private final DateTime lastReportedAt;
    private final DateTime createdAt;
    private final DateTime updatedAt;

    // Mutable
    private String name;

    // Submodel
    private List<Identifier> identifiers;
    private Space space;


    /**
     * Methods
     */

    public Device(int id, int accountId, Integer deviceManifestId, DateTime lastReportedAt, DateTime createdAt, DateTime updatedAt) {
        this.id = id;
        this.accountId = accountId;
        this.deviceManifestId = deviceManifestId;
        this.lastReportedAt = lastReportedAt;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public Integer getDeviceManifestId() {
        return deviceManifestId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DateTime getLastReportedAt() {
        return lastReportedAt;
    }

    public DateTime getCreatedAt() {
        return createdAt;
    }

    public DateTime getUpdatedAt() {
        return updatedAt;
    }

    public List<Identifier> getIdentifiers() {
        return identifiers;
    }

    public Space getSpace() {
        return space;
    }

    public void setIdentifiers(List<Identifier> identifiers) {
        this.identifiers = identifiers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Device device = (Device) o;
        return Objects.equal(id, device.id) &&
                Objects.equal(accountId, device.accountId) &&
                Objects.equal(deviceManifestId, device.deviceManifestId) &&
                Objects.equal(lastReportedAt, device.lastReportedAt) &&
                Objects.equal(createdAt, device.createdAt) &&
                Objects.equal(updatedAt, device.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, accountId, deviceManifestId, lastReportedAt, createdAt, updatedAt);
    }

    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", accountId=" + accountId +
                ", deviceManifestId=" + deviceManifestId +
                ", name='" + name + '\'' +
                ", lastReportedAt=" + lastReportedAt +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", identifiers=" + identifiers +
                '}';
    }

    @Override
    public String getMimeType() {
        return MIME_TYPE;
    }

    public static class PostRequest {

        private final int deviceManifestId;
        private final String name;

        public PostRequest(int deviceManifestId, String name) {
            this.deviceManifestId = deviceManifestId;
            this.name = name;
        }
    }
}
