package com.robinpowered.sdk.model;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

public class CalendarTest {

    @Test
    public void testEqualsAndHashcode() {
        EqualsVerifier.forClass(Calendar.class)
                .withRedefinedSuperclass()
                .usingGetClass()
                .verify();
    }
}
