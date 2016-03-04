package com.robinpowered.sdk.model;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

public class UserOrganizationTest {

    @Test
    public void testEqualsAndHashcode() {
        EqualsVerifier.forClass(UserOrganization.class)
                .usingGetClass()
                .verify();
    }
}
