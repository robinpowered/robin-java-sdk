package com.robinpowered.sdk.model;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

public class IdentifierTest {

    @Test
    public void testEqualsAndHashcode() {
        EqualsVerifier.forClass(Identifier.class)
                .withRedefinedSuperclass()
                .usingGetClass()
                .verify();
    }
}
