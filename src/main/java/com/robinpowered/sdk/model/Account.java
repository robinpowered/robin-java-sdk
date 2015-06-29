package com.robinpowered.sdk.model;

import com.google.common.base.Objects;
import org.joda.time.DateTime;

/**
 * A base class for a {@link User} or {@link Organization}.
 */
abstract public class Account implements IdentifiableApiResponseModel {

    /**
     * Constants
     */

    public static final String MIME_TYPE = "vnd.robinpowered.account.v1";


    /**
     * Properties
     */

    // Immutable
    private final int id;
    private final String slug;
    private final boolean isOrganization;
    private final DateTime createdAt;
    private final DateTime updatedAt;

    // Mutable
    private String name;
    private String avatar;


    /**
     * Methods
     */

    public Account(int id, String slug, boolean isOrganization, DateTime createdAt, DateTime updatedAt) {
        this.id = id;
        this.slug = slug;
        this.isOrganization = isOrganization;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    @Override
    public int getId() {
        return id;
    }

    public Boolean isOrganization() {
        return isOrganization;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
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
        Account account = (Account) o;
        return Objects.equal(id, account.id) &&
                Objects.equal(isOrganization, account.isOrganization) &&
                Objects.equal(slug, account.slug) &&
                Objects.equal(createdAt, account.createdAt) &&
                Objects.equal(updatedAt, account.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, slug, isOrganization, createdAt, updatedAt);
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", isOrganization=" + isOrganization +
                ", name='" + name + '\'' +
                ", slug='" + slug + '\'' +
                ", avatar='" + avatar + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

    @Override
    public String getMimeType() {
        return MIME_TYPE;
    }
}
