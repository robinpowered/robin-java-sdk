package com.robinpowered.sdk.exception;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.converter.ConversionException;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.powermock.api.mockito.PowerMockito.doReturn;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Response.class, HttpException.class})
public class RobinExceptionHandlerTest {

    @Test
    public void testHandleConversionError() {
        RobinExceptionHandler handler = new RobinExceptionHandler();

        Throwable cause = mock(ConversionException.class);
        RetrofitError error = mock(RetrofitError.class);
        when(error.getCause()).thenReturn(cause);

        Throwable result = handler.handleError(error);

        // Should return the original error.
        assertThat(result).isEqualTo(error);
    }

    @Test
    public void testHandleIOException() {
        RobinExceptionHandler handler = new RobinExceptionHandler();

        Throwable cause = mock(IOException.class);
        RetrofitError error = mock(RetrofitError.class);
        when(error.getCause()).thenReturn(cause);

        Throwable result = handler.handleError(error);

        // Should return the cause, not the error.
        assertThat(result).isEqualTo(cause);
    }

    @Test
    public void testHandleErrorWithResponse() throws Exception {
        RobinExceptionHandler handler = new RobinExceptionHandler();

        RetrofitError error = mock(RetrofitError.class);
        Response response = mock(Response.class);
        HttpException httpException = mock(HttpException.class);
        mockStatic(HttpException.class, Mockito.CALLS_REAL_METHODS);

        when(error.getResponse()).thenReturn(response);
        doReturn(httpException).when(HttpException.class, "factory", error);

        Throwable result = handler.handleError(error);

        // Should return the result of HttpException.factory()
        assertThat(result).isEqualTo(httpException);
    }

    @Test
    public void testHandleErrorWithNoResponse() throws Exception {
        RobinExceptionHandler handler = new RobinExceptionHandler();

        RetrofitError error = mock(RetrofitError.class);

        when(error.getResponse()).thenReturn(null);

        Throwable result = handler.handleError(error);

        // Should return the original error.
        assertThat(result).isEqualTo(error);
    }
}
