package com.robinpowered.sdk.exception;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import retrofit.RetrofitError;
import retrofit.client.Response;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.powermock.api.mockito.PowerMockito.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Response.class, HttpException.class})
public class HttpExceptionTest {

    @Test
    public void testConstructors()
    {
        String testMessage = "Hello world.";
        Throwable cause = new RuntimeException();
        int statusCode = 1;

        // Test HttpException(String)
        HttpException e1 = new HttpException(testMessage);
        assertThat(e1.getMessage()).isEqualTo(testMessage);

        // Test HttpException(Throwable)
        HttpException e2 = new HttpException(cause);
        assertThat(e2.getCause()).isEqualTo(cause);

        // Test HttpException(String, Throwable)
        HttpException e3 = new HttpException(testMessage, cause);
        assertThat(e3.getMessage()).isEqualTo(testMessage);
        assertThat(e3.getCause()).isEqualTo(cause);

        // Test HttpException(String, Throwable, int)
        HttpException e4 = new HttpException(testMessage, cause, statusCode);
        assertThat(e4.getMessage()).isEqualTo(testMessage);
        assertThat(e4.getCause()).isEqualTo(cause);
        assertThat(e4.getStatusCode()).isEqualTo(statusCode);
    }

    @Test
    public void testFactory() throws Exception {
        Response response = mock(Response.class);
        RetrofitError error = mock(RetrofitError.class);
        mockStatic(HttpException.class, Mockito.CALLS_REAL_METHODS);

        when(error.getResponse()).thenReturn(null);
        assertThat(HttpException.factory(error)).isExactlyInstanceOf(HttpException.class);

        when(error.getResponse()).thenReturn(response);

        doReturn(true).when(HttpException.class, "isClientError", response);
        assertThat(HttpException.factory(error)).isExactlyInstanceOf(ClientErrorResponseException.class);

        doReturn(false).when(HttpException.class, "isClientError", response);
        doReturn(true).when(HttpException.class, "isServerError", response);
        assertThat(HttpException.factory(error)).isExactlyInstanceOf(ServerErrorResponseException.class);
    }

    @Test
    public void testFactoryWithNull() throws Exception {
        HttpException result = HttpException.factory(null);
        assertThat(result).isNotNull();
        assertThat(result.getCause()).isNull();
    }

    @Test
    public void testIsClientError() {
        // Null exception should return false
        assertThat(HttpException.isClientError(null)).isFalse();

        Response response = mock(Response.class);

        // Test with a 500
        when(response.getStatus()).thenReturn(500);
        assertThat(HttpException.isClientError(response)).isFalse();

        // Test with a 400
        when(response.getStatus()).thenReturn(400);
        assertThat(HttpException.isClientError(response)).isTrue();
    }

    @Test
    public void testIsServerError() {
        // Null exception should return false
        assertThat(HttpException.isServerError(null)).isFalse();

        Response response = mock(Response.class);

        // Test with a 400
        when(response.getStatus()).thenReturn(400);
        assertThat(HttpException.isServerError(response)).isFalse();

        // Test with a 500
        when(response.getStatus()).thenReturn(500);
        assertThat(HttpException.isServerError(response)).isTrue();
    }

    @Test
    public void testGetStatusCode() {
        Throwable throwable = mock(Throwable.class);
        HttpException exception = new HttpException("test", throwable, 420);

        assertThat(exception.getStatusCode()).isEqualTo(420);
    }
}
