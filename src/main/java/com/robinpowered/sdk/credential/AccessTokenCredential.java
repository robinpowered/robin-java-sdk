package com.robinpowered.sdk.credential;

import com.robinpowered.sdk.model.Token;

public class AccessTokenCredential implements Credential {

    /**
     * Constants
     */

    public static final String TYPE = "Access-Token";


    /**
     * Properties
     */

    private String token;


    /**
     * Methods
     */

    public AccessTokenCredential(String token) {
        if (token == null) {
            throw new IllegalArgumentException("The token cannot be null.");
        }

        this.token = token;
    }

    public AccessTokenCredential(Token token) {
        this.token = token.getAccessToken();
    }

    @Override
    public String getType() {
        return TYPE;
    }

    @Override
    public String getValue() {
        return token;
    }

    @Override
    public String getBuiltValue() {
        return getType() + " " + token;
    }

    @Override
    public String toString() {
        return getBuiltValue();
    }
}
