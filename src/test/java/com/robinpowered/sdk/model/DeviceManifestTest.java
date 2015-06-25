package com.robinpowered.sdk.model;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

public class DeviceManifestTest {

    @Test
    public void testEqualsAndHashcode() {
        EqualsVerifier.forClass(DeviceManifest.class)
                .withRedefinedSuperclass()
                .usingGetClass()
                .verify();
    }

    @Test
    public void testFeedsEqualsAndHashcode() {
        EqualsVerifier.forClass(DeviceManifest.Feed.class)
                .withRedefinedSuperclass()
                .usingGetClass()
                .verify();
    }
}
