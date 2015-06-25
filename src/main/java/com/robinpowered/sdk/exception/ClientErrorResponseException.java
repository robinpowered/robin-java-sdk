package com.robinpowered.sdk.exception;

public class ClientErrorResponseException extends HttpException {

    public ClientErrorResponseException(String message) {
        super(message);
    }

    public ClientErrorResponseException(Throwable throwable) {
        super(throwable);
    }

    public ClientErrorResponseException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public ClientErrorResponseException(String message, Throwable throwable, int statusCode) {
        super(message, throwable, statusCode);
    }
}
