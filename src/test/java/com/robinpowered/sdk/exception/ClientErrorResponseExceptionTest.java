package com.robinpowered.sdk.exception;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(PowerMockRunner.class)
public class ClientErrorResponseExceptionTest {

    @Test
    public void testConstructors()
    {
        String testMessage = "Hello world.";
        Throwable cause = new RuntimeException();
        int statusCode = 1;

        // Test ClientErrorResponseException(String)
        ClientErrorResponseException e1 = new ClientErrorResponseException(testMessage);
        assertThat(e1.getMessage()).isEqualTo(testMessage);

        // Test ClientErrorResponseException(Throwable)
        ClientErrorResponseException e2 = new ClientErrorResponseException(cause);
        assertThat(e2.getCause()).isEqualTo(cause);

        // Test ClientErrorResponseException(String, Throwable)
        ClientErrorResponseException e3 = new ClientErrorResponseException(testMessage, cause);
        assertThat(e3.getMessage()).isEqualTo(testMessage);
        assertThat(e3.getCause()).isEqualTo(cause);

        // Test ClientErrorResponseException(String, Throwable, int)
        ClientErrorResponseException e4 = new ClientErrorResponseException(testMessage, cause, statusCode);
        assertThat(e4.getMessage()).isEqualTo(testMessage);
        assertThat(e4.getCause()).isEqualTo(cause);
        assertThat(e4.getStatusCode()).isEqualTo(statusCode);
    }
}
