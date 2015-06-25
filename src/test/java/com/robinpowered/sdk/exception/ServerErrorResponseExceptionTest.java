package com.robinpowered.sdk.exception;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(PowerMockRunner.class)
public class ServerErrorResponseExceptionTest {

    @Test
    public void testConstructors()
    {
        String testMessage = "Hello world.";
        Throwable cause = new RuntimeException();
        int statusCode = 1;

        // Test ServerErrorResponseException(String)
        ServerErrorResponseException e1 = new ServerErrorResponseException(testMessage);
        assertThat(e1.getMessage()).isEqualTo(testMessage);

        // Test ServerErrorResponseException(Throwable)
        ServerErrorResponseException e2 = new ServerErrorResponseException(cause);
        assertThat(e2.getCause()).isEqualTo(cause);

        // Test ServerErrorResponseException(String, Throwable)
        ServerErrorResponseException e3 = new ServerErrorResponseException(testMessage, cause);
        assertThat(e3.getMessage()).isEqualTo(testMessage);
        assertThat(e3.getCause()).isEqualTo(cause);

        // Test ServerErrorResponseException(String, Throwable, int)
        ServerErrorResponseException e4 = new ServerErrorResponseException(testMessage, cause, statusCode);
        assertThat(e4.getMessage()).isEqualTo(testMessage);
        assertThat(e4.getCause()).isEqualTo(cause);
        assertThat(e4.getStatusCode()).isEqualTo(statusCode);
    }
}
