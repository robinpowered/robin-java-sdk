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
public class Device implements IdentifiableApiResponseModel {

    /**
     * Constants
     */

    public static final String MIME_TYPE = "vnd.robinpowered.device.v1";


    /**
     * Properties
     */

    private final int id;
    private final int accountId;
    private Integer deviceManifestId;
    private String name;
    private DateTime lastReportedAt;
    private DateTime createdAt;
    private DateTime updatedAt;
    private List<Identifier> identifiers;


    /**
     * Methods
     */

    public Device(int id, int accountId) {
        this.id = id;
        this.accountId = accountId;
    }

    @Override
    public int getId() {
        return id;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public Integer getDeviceManifestId() {
        return deviceManifestId;
    }

    public void setDeviceManifestId(Integer deviceManifestId) {
        this.deviceManifestId = deviceManifestId;
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

    public void setLastReportedAt(DateTime lastReportedAt) {
        this.lastReportedAt = lastReportedAt;
    }

    public DateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(DateTime createdAt) {
        this.createdAt = createdAt;
    }

    public DateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(DateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<Identifier> getIdentifiers() {
        return identifiers;
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
                Objects.equal(accountId, device.accountId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, accountId);
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
}
