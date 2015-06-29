package com.robinpowered.sdk.model;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EmailTest {

    @Test
    public void testEqualsAndHashcode() {
        EqualsVerifier.forClass(User.Email.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void testToString() {
        String emailString = "brian@robinpowered.com";
        User.Email email = new User.Email(emailString, false);

        assertThat(email.toString()).isEqualTo(emailString);
    }
}
