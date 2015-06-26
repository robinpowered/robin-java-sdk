package com.robinpowered.sdk.model;

import com.google.common.base.Objects;
import org.joda.time.DateTime;

/**
 * @deprecated This feature is being redesigned.
 */
public class Dibs implements ApiResponseModel {


    /**
     * Constants
     */

    public static final String MIME_TYPE = "vnd.robinpowered.dibs.v1";


    /**
     * Properties
     */

    private Integer spaceId;
    private Integer userId;
    private DateTime expiredAt;
    private User user;
    private Space space;


    /**
     * Methods
     */

    public Integer getSpaceId() {
        return spaceId;
    }

    public void setSpaceId(Integer spaceId) {
        this.spaceId = spaceId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public DateTime getExpiredAt() {
        return expiredAt;
    }

    public void setExpiredAt(DateTime expiredAt) {
        this.expiredAt = expiredAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Space getSpace() {
        return space;
    }

    public void setSpace(Space space) {
        this.space = space;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dibs dibs = (Dibs) o;
        return Objects.equal(spaceId, dibs.spaceId) &&
                Objects.equal(userId, dibs.userId) &&
                Objects.equal(expiredAt, dibs.expiredAt);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(spaceId, userId, expiredAt);
    }

    @Override
    public String toString() {
        return "Dibs{" +
                "spaceId=" + spaceId +
                ", userId=" + userId +
                ", expiredAt=" + expiredAt +
                ", user=" + user +
                ", space=" + space +
                '}';
    }

    @Override
    public String getMimeType() {
        return MIME_TYPE;
    }
}
