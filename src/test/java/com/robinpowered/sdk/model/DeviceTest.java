package com.robinpowered.sdk.model;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

public class DeviceTest {

    @Test
    public void testEqualsAndHashcode() {
        EqualsVerifier.forClass(Device.class)
                .usingGetClass()
                .verify();
    }
}
