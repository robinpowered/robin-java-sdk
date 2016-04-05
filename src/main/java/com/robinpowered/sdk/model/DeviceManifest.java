package com.robinpowered.sdk.model;

import com.google.common.base.Objects;
import org.joda.time.DateTime;

import java.util.List;

/**
 * A collection of meta information about a {@link Device}.
 */
public class DeviceManifest implements IdentifiableApiResponseModel<Integer> {

    /**
     * Constants
     */

    public static final String MIME_TYPE = "vnd.robinpowered.device-manifest.v1";


    /**
     * Properties
     */

    // Immutable
    private final int id;
    private final String name;
    private final String slug;
    private final Boolean isRelay;
    private final String presencePublisherType;
    private final DateTime createdAt;
    private final DateTime updatedAt;

    // Immutable Submodels
    private final List<Feed> feeds;


    /**
     * Methods
     */

    public DeviceManifest(int id, String name, String slug, Boolean isRelay, String presencePublisherType,
                          DateTime createdAt, DateTime updatedAt, List<Feed> feeds) {
        this.id = id;
        this.name = name;
        this.slug = slug;
        this.isRelay = isRelay;
        this.presencePublisherType = presencePublisherType;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.feeds = feeds;
    }


    @Override
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSlug() {
        return slug;
    }

    public Boolean isRelay() {
        return isRelay;
    }

    public String getPresencePublisherType() {
        return presencePublisherType;
    }

    public DateTime getCreatedAt() {
        return createdAt;
    }

    public DateTime getUpdatedAt() {
        return updatedAt;
    }

    public List<Feed> getFeeds() {
        return feeds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeviceManifest that = (DeviceManifest) o;
        return Objects.equal(id, that.id) &&
                Objects.equal(name, that.name) &&
                Objects.equal(slug, that.slug) &&
                Objects.equal(isRelay, that.isRelay) &&
                Objects.equal(presencePublisherType, that.presencePublisherType) &&
                Objects.equal(createdAt, that.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, name, slug, isRelay, presencePublisherType, createdAt);
    }

    @Override
    public String toString() {
        return "DeviceManifest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", slug='" + slug + '\'' +
                ", isRelay=" + isRelay +
                ", presencePublisherType='" + presencePublisherType + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", feeds=" + feeds +
                '}';
    }

    @Override
    public String getMimeType() {
        return MIME_TYPE;
    }

    public static class Feed implements IdentifiableApiResponseModel<Integer> {

        /**
         * Constants
         */

        public static final String MIME_TYPE = "vnd.robinpowered.device-feed.v1";


        /**
         * Properties
         */

        private final int id;
        private final Integer deviceManifestId;
        private final String name;
        private final String unit;
        private final DateTime createdAt;
        private final DateTime updatedAt;


        /**
         * Methods
         */

        public Feed(int id, Integer deviceManifestId, String name, String unit, DateTime createdAt,
                    DateTime updatedAt) {

            this.id = id;
            this.deviceManifestId = deviceManifestId;
            this.name = name;
            this.unit = unit;
            this.createdAt = createdAt;
            this.updatedAt = updatedAt;
        }

        @Override
        public Integer getId() {
            return id;
        }

        public Integer getDeviceManifestId() {
            return deviceManifestId;
        }

        public String getName() {
            return name;
        }

        public String getUnit() {
            return unit;
        }

        public DateTime getCreatedAt() {
            return createdAt;
        }

        public DateTime getUpdatedAt() {
            return updatedAt;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Feed feed = (Feed) o;
            return Objects.equal(id, feed.id) &&
                    Objects.equal(deviceManifestId, feed.deviceManifestId) &&
                    Objects.equal(name, feed.name) &&
                    Objects.equal(unit, feed.unit);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(id, deviceManifestId, name, unit);
        }

        @Override
        public String toString() {
            return "Feed{" +
                    "id=" + id +
                    ", deviceManifestId=" + deviceManifestId +
                    ", name='" + name + '\'' +
                    ", unit='" + unit + '\'' +
                    ", createdAt=" + createdAt +
                    ", updatedAt=" + updatedAt +
                    '}';
        }

        @Override
        public String getMimeType() {
            return MIME_TYPE;
        }
    }
}
