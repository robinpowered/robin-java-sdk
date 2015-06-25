package com.robinpowered.sdk.exception;

public class ServerErrorResponseException extends HttpException {
    public ServerErrorResponseException(String message) {
        super(message);
    }

    public ServerErrorResponseException(Throwable throwable) {
        super(throwable);
    }

    public ServerErrorResponseException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public ServerErrorResponseException(String message, Throwable throwable, int statusCode) {
        super(message, throwable, statusCode);
    }
}
