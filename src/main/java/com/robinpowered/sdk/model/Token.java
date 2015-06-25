package com.robinpowered.sdk.model;

import com.google.common.base.Objects;

/**
 * A model that contains an access token that may be used to authenticate with the Robin API.
 */
public class Token implements ApiResponseModel {

    /**
     * Constants
     */

    public static final String MIME_TYPE = "vnd.robinpowered.token.v1";


    /**
     * Properties
     */

    private final String accessToken;


    /**
     * Methods
     */

    /**
     * Constructs an instance from an access token string.
     *
     * @param accessToken An access token.
     */
    public Token(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Token token = (Token) o;
        return Objects.equal(accessToken, token.accessToken);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(accessToken);
    }

    @Override
    public String toString() {
        return "Token{" +
                "accessToken='" + accessToken + '\'' +
                '}';
    }

    @Override
    public String getMimeType() {
        return MIME_TYPE;
    }
}
