package com.robinpowered.sdk.model;

import com.google.common.base.Objects;
import org.joda.time.DateTime;

/**
 * A time period (session) that a user was detected in a space or location.
 *
 * <p>
 * A presence object may be associated with a {@link User} resource directly, or with a
 * {@link Device}. If presence is associated to a device, that typically indicates that a person
 * is sensed but cannot be identified. This is common when detecting presence using devices such as
 * IR sensors.
 *
 * <p>
 * Upon creation, the arrived_at attribute is initialized to the current time and the
 * {@code expired_at}  value is set to the TTL (time to live) added to the current time.
 *
 * <p>
 * Each time presence is posted for a user or device that already has an active presence session
 * (a session in the same space that hasn't expired) than the active session will be lengthened by
 * the provided TTL. Otherwise a new presence session is created.
 *
 * <p>
 * <em>NOTE: The maximum allowed TTL is 20 minutes, however for the best results a lower TTL (such as 5
 * minutes) is recommended. In the future the maximum allowed TTL may be reduced.</em>
 */
public class Presence implements ApiResponseModel {

    /**
     * Constants
     */

    public static final String MIME_TYPE = "vnd.robinpowered.presence.v1";


    /**
     * Properties
     */

    // Immutable
    private final Integer spaceId;
    private final Integer locationId;
    private final Integer userId;
    private final Integer deviceId;
    private final DateTime lastSeenAt;
    private final DateTime arrivedAt;
    private final DateTime expiredAt;
    private final Integer sessionTtl;
    private final Boolean sessionActive;

    // Mutable
    private User user;
    private Device device;


    /**
     * Methods
     */

    public Presence(Integer spaceId, Integer locationId, Integer userId, Integer deviceId, DateTime lastSeenAt,
                    DateTime arrivedAt, DateTime expiredAt, Integer sessionTtl, Boolean sessionActive) {

        this.spaceId = spaceId;
        this.locationId = locationId;
        this.userId = userId;
        this.deviceId = deviceId;
        this.lastSeenAt = lastSeenAt;
        this.arrivedAt = arrivedAt;
        this.expiredAt = expiredAt;
        this.sessionTtl = sessionTtl;
        this.sessionActive = sessionActive;
    }


    public Integer getSpaceId() {
        return spaceId;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public DateTime getLastSeenAt() {
        return lastSeenAt;
    }

    public DateTime getArrivedAt() {
        return arrivedAt;
    }

    public DateTime getExpiredAt() {
        return expiredAt;
    }

    public Integer getSessionTtl() {
        return sessionTtl;
    }

    public Boolean getSessionActive() {
        return sessionActive;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Presence presence = (Presence) o;
        return Objects.equal(spaceId, presence.spaceId) &&
                Objects.equal(locationId, presence.locationId) &&
                Objects.equal(userId, presence.userId) &&
                Objects.equal(deviceId, presence.deviceId) &&
                Objects.equal(lastSeenAt, presence.lastSeenAt) &&
                Objects.equal(arrivedAt, presence.arrivedAt) &&
                Objects.equal(expiredAt, presence.expiredAt) &&
                Objects.equal(sessionTtl, presence.sessionTtl) &&
                Objects.equal(sessionActive, presence.sessionActive);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(spaceId, locationId, userId, deviceId, lastSeenAt, arrivedAt,
                expiredAt, sessionTtl, sessionActive);
    }

    @Override
    public String toString() {
        return "Presence{" +
                "spaceId=" + spaceId +
                ", locationId=" + locationId +
                ", userId=" + userId +
                ", deviceId=" + deviceId +
                ", lastSeenAt=" + lastSeenAt +
                ", arrivedAt=" + arrivedAt +
                ", expiredAt=" + expiredAt +
                ", sessionTtl=" + sessionTtl +
                ", sessionActive=" + sessionActive +
                ", user=" + user +
                ", device=" + device +
                '}';
    }

    @Override
    public String getMimeType() {
        return MIME_TYPE;
    }

    public static class RequestFormat {
        private String userRef;
        private Integer deviceId;
        private Integer sessionTtl;

        public RequestFormat(String userRef, Integer deviceId, Integer sessionTtl) {
            this.userRef = userRef;
            this.deviceId = deviceId;
            this.sessionTtl = sessionTtl;
        }

        public String getUserRef() {
            return userRef;
        }

        public Integer getDeviceId() {
            return deviceId;
        }

        public Integer getSessionTtl() {
            return sessionTtl;
        }
    }
}
