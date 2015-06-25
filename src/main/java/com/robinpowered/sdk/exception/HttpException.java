package com.robinpowered.sdk.exception;

import com.sun.javafx.beans.annotations.NonNull;
import retrofit.RetrofitError;
import retrofit.client.Response;

import java.io.IOException;

public class HttpException extends IOException {

    /**
     * Properties
     */
    private int statusCode;

    /**
     * Methods
     */

    public HttpException(String message) {
        super(message);
    }

    public HttpException(Throwable throwable) {
        super(throwable);
    }

    public HttpException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public HttpException(String message, Throwable throwable, int statusCode) {
        super(message, throwable);
        this.statusCode = statusCode;
    }


    /**
     * RetroFit specific
     */

    public static HttpException factory(@NonNull RetrofitError error) {
        HttpException exception = new HttpException(error);

        Response response = error.getResponse();

        if (response != null) {
            int statusCode = response.getStatus();

            // Build our message
            String message = "Status Code: " + response.getStatus()
                    + "; URL: " + response.getUrl()
                    + ";";

            if (isClientError(response)) {
                exception = new ClientErrorResponseException(message, error, statusCode);
            } else if (isServerError(response)) {
                exception = new ServerErrorResponseException(message, error, statusCode);
            }
        }

        return exception;
    }

    public static boolean isClientError(Response httpResponse) {
        if (null != httpResponse) {
            int code = httpResponse.getStatus();

            return (400 <= code && code <= 499);
        }

        return false;
    }

    public static boolean isServerError(Response httpResponse) {
        if (null != httpResponse) {
            int code = httpResponse.getStatus();

            return (500 <= code && code <= 599);
        }

        return false;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
