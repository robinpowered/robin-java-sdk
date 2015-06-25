package com.robinpowered.sdk.model.exception;

import java.net.URISyntaxException;

public class UrnSyntaxException extends URISyntaxException {

    /**
     * Methods
     */

    public UrnSyntaxException(String input, String reason, int index) {
        super(input, reason, index);
    }

    public UrnSyntaxException(String input, String reason) {
        super(input, reason);
    }
}
