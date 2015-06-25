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

    // Mutable
    private Boolean isOrganization;
    private String name;
    private String avatar;
    private DateTime createdAt;
    private DateTime updatedAt;


    /**
     * Methods
     */

    public Account(int id, String slug) {
        this.id = id;
        this.slug = slug;
    }

    @Override
    public int getId() {
        return id;
    }

    public Boolean isOrganization() {
        return isOrganization;
    }

    public void setIsOrganization(Boolean isOrganization) {
        this.isOrganization = isOrganization;
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

    public void setCreatedAt(DateTime createdAt) {
        this.createdAt = createdAt;
    }

    public DateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(DateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equal(id, account.id) &&
                Objects.equal(slug, account.slug);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, slug);
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
