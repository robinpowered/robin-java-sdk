package com.robinpowered.sdk.model;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

public class UserAccessTest {

    @Test
    public void testEqualsAndHashcode() {
        EqualsVerifier.forClass(UserAccess.class)
                .usingGetClass()
                .verify();
    }
}
