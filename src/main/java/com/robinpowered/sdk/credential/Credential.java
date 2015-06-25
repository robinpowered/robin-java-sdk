package com.robinpowered.sdk.credential;

public interface Credential {

    String getType();

    String getValue();

    String getBuiltValue();
}
