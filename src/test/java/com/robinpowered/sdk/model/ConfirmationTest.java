package com.robinpowered.sdk.model;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

public class ConfirmationTest {

    @Test
    public void testEqualsAndHashcode() {
        EqualsVerifier.forClass(Confirmation.class)
                .usingGetClass()
                .verify();
    }
}
