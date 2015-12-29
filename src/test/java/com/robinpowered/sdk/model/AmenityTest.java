package com.robinpowered.sdk.model;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

public class AmenityTest {

    @Test
    public void testEqualsAndHashcode() {
        EqualsVerifier.forClass(Amenity.class)
                .usingGetClass()
                .verify();
    }
}
