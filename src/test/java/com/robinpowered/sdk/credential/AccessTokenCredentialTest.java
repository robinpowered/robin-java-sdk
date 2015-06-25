package com.robinpowered.sdk.credential;

import com.robinpowered.sdk.model.Token;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AccessTokenCredentialTest
{
    private final String testToken = "abcd";

    @Test
    public void testConstructors()
    {
        AccessTokenCredential credential = new AccessTokenCredential(testToken);
        assertThat(credential.getValue()).isEqualTo(testToken);

        Token token = mock(Token.class);
        when(token.getAccessToken())
                .thenReturn(testToken);

        credential = new AccessTokenCredential(token);
        assertThat(credential.getValue()).isEqualTo(testToken);
    }

    @Test
    public void testGetType()
    {
        AccessTokenCredential credential = new AccessTokenCredential(testToken);
        assertThat(credential.getType()).isEqualTo(AccessTokenCredential.TYPE);
    }

    @Test
    public void testGetBuiltValue()
    {
        AccessTokenCredential credential = new AccessTokenCredential(testToken);
        assertThat(credential.getBuiltValue()).isEqualTo("Access-Token " + testToken);
    }

    @Test
    public void testToString()
    {
        AccessTokenCredential credential = new AccessTokenCredential(testToken);
        assertThat(credential.toString()).isEqualTo("Access-Token " + testToken);
    }
}
