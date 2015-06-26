package com.robinpowered.sdk.exception;

import retrofit.ErrorHandler;
import retrofit.RetrofitError;
import retrofit.converter.ConversionException;

import java.io.IOException;

public class RobinExceptionHandler implements ErrorHandler {

    @Override
    public Throwable handleError(RetrofitError cause) {
        // Get the nested cause
        Throwable previous = cause.getCause();

        if (previous instanceof ConversionException) {
            return cause;
        } else if (previous instanceof IOException) {
            // IOExceptions are explicitly thrown by the service and should be handled by the client
            return previous;
        } else if (null != cause.getResponse()) {
            return HttpException.factory(cause);
        }

        return cause;
    }
}
