package com.robinpowered.sdk.model;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

public class EventTest {

    @Test
    public void testEqualsAndHashcode() {
        EqualsVerifier.forClass(Event.class)
                .withRedefinedSuperclass()
                .usingGetClass()
                .verify();
    }
}
