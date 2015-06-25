package com.robinpowered.sdk.model;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

public class TokenTest {

    @Test
    public void testEqualsAndHashcode() {
        EqualsVerifier.forClass(Token.class)
                .usingGetClass()
                .verify();
    }
}
