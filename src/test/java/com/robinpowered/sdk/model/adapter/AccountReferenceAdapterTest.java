package com.robinpowered.sdk.model.adapter;

import com.robinpowered.sdk.model.Account;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AccountReferenceAdapterTest {

    @Test
    public void testSerialize() throws Exception {
        String slug = "brian";
        int id = 1;
        AccountReferenceAdapter adapter = new AccountReferenceAdapter();

        // Create mocks
        Account.Reference ref = mock(Account.Reference.class);

        // Test for slug
        when(ref.getId()).thenReturn(null);
        when(ref.getSlug()).thenReturn(slug);
        assertThat(adapter.serialize(ref, Account.Reference.class, null).getAsString()).isEqualTo(slug);

        // Test for id
        when(ref.getId()).thenReturn(id);
        when(ref.getSlug()).thenReturn(null);
        assertThat(adapter.serialize(ref, Account.Reference.class, null).getAsInt()).isEqualTo(id);
    }
}
