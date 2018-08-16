package com.robinpowered.sdk.credential;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BearerTokenCredentialTest
{
    private final String testToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c";

    @Test
    public void testConstructors()
    {
        BearerTokenCredential credential = new BearerTokenCredential(testToken);
        assertThat(credential.getValue()).isEqualTo(testToken);
    }

    @Test
    public void testGetType()
    {
        BearerTokenCredential credential = new BearerTokenCredential(testToken);
        assertThat(credential.getType()).isEqualTo(BearerTokenCredential.TYPE);
    }

    @Test
    public void testGetBuiltValue()
    {
        BearerTokenCredential credential = new BearerTokenCredential(testToken);
        assertThat(credential.getBuiltValue()).isEqualTo("Bearer " + testToken);
    }

    @Test
    public void testToString()
    {
        BearerTokenCredential credential = new BearerTokenCredential(testToken);
        assertThat(credential.toString()).isEqualTo("Bearer " + testToken);
    }
}
