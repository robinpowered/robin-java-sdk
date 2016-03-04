package com.robinpowered.sdk.model;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

public class SpaceTest {

    @Test
    public void testEqualsAndHashcode() {
        EqualsVerifier.forClass(Space.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void testEqualsAndHashcodeForState() {
        EqualsVerifier.forClass(Space.State.class)
                .usingGetClass()
                .verify();
    }
}
