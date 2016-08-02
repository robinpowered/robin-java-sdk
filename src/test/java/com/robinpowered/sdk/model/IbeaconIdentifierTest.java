package com.robinpowered.sdk.model;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class IbeaconIdentifierTest {

    @Test
    public void testEqualsAndHashcode() {
        EqualsVerifier.forClass(IbeaconIdentifier.class)
                .usingGetClass()
                .verify();
    }
}
