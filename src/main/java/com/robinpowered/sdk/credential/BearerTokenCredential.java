package com.robinpowered.sdk.credential;

public class BearerTokenCredential implements Credential {

    /**
     * Constants
     */

    public static final String TYPE = "Bearer";


    /**
     * Properties
     */

    private String token;


    /**
     * Methods
     */

    public BearerTokenCredential(String token) {
        if (token == null) {
            throw new IllegalArgumentException("The token cannot be null.");
        }

        this.token = token;
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
