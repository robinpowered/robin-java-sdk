package com.robinpowered.sdk.model;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

public class InviteeTest {

    @Test
    public void testEqualsAndHashcode() {
        EqualsVerifier.forClass(Invitee.class)
                .usingGetClass()
                .verify();
    }
}
