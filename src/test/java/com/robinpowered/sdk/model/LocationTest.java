package com.robinpowered.sdk.model;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

public class LocationTest {

    @Test
    public void testEqualsAndHashcode() {
        EqualsVerifier.forClass(Location.class)
                .withRedefinedSuperclass()
                .usingGetClass()
                .verify();
    }
}
