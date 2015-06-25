package com.robinpowered.sdk.model;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

public class UserTest {

    @Test
    public void testEqualsAndHashcode() {
        EqualsVerifier.forClass(User.class)
                .withRedefinedSuperclass()
                .usingGetClass()
                .verify();
    }
}
