package com.robinpowered.sdk.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ReferenceTest {

    @Test
    public void testToString() throws Exception {
        String slug = "brian";
        Account.Reference reference1 = new Account.Reference(slug);
        assertThat(reference1.toString()).isEqualTo(slug);

        Integer id = 10;
        Account.Reference reference2 = new Account.Reference(id);
        assertThat(reference2.toString()).isEqualTo(id.toString());
    }
}
