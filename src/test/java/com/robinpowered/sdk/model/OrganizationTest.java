package com.robinpowered.sdk.model;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

public class OrganizationTest {

    @Test
    public void testEqualsAndHashcode() {
        EqualsVerifier.forClass(Organization.class)
                .withRedefinedSuperclass()
                .usingGetClass()
                .verify();
    }

}
