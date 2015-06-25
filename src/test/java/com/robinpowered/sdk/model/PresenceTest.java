package com.robinpowered.sdk.model;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

public class PresenceTest {

    @Test
    public void testEqualsAndHashcode() {
        EqualsVerifier.forClass(Presence.class)
                .withRedefinedSuperclass()
                .usingGetClass()
                .verify();
    }

}
