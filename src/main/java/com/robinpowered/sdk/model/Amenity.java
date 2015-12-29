package com.robinpowered.sdk.model;

import com.google.common.base.Objects;
import org.joda.time.DateTime;

/**
 * An amenity that may be associated with a {@link Space}.
 *
 * <p>
 * Amenities may be created or removed within an organization, though a default set of amenities is always present.
 * Each amenity may then be associated or disassociated from any spaces within that organization.
 */
public class Amenity implements ApiResponseModel {

    /**
     * Constants
     */

    public static final String MIME_TYPE = "vnd.robinpowered.amenity.v1";


    /**
     * Properties
     */

    // Immutable
    private final int id;
    private final Integer accountId;
    private final DateTime createdAt;
    private final DateTime updatedAt;

    // Mutable
    private String name;


    /**
     * Methods
     */

    public Amenity(int id, Integer accountId, DateTime createdAt, DateTime updatedAt) {
        this.id = id;
        this.accountId = accountId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getId() {
        return id;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public DateTime getCreatedAt() {
        return createdAt;
    }

    public DateTime getUpdatedAt() {
        return updatedAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Amenity amenity = (Amenity) o;
        return Objects.equal(id, amenity.id) &&
                Objects.equal(accountId, amenity.accountId) &&
                Objects.equal(createdAt, amenity.createdAt) &&
                Objects.equal(updatedAt, amenity.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, accountId, createdAt, updatedAt);
    }

    @Override
    public String   toString() {
        return "Amenity{" +
                "id=" + id +
                ", accountId=" + accountId +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public String getMimeType() {
        return MIME_TYPE;
    }
}
