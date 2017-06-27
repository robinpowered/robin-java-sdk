package com.robinpowered.sdk.exception;

import com.robinpowered.sdk.model.ApiResponse;
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

    public static HttpException factory(RetrofitError error) {
        HttpException exception = new HttpException(error);

        Response response = error != null ? error.getResponse() : null;

        if (response != null) {
            String responseMessage = null;
            if (error.getBody() instanceof ApiResponse) {
                ApiResponse body = (ApiResponse) error.getBody();
                responseMessage = body.getMeta().getMessage();
            }

            // Build our message
            String message = "Status Code: " + response.getStatus()
                    + "; URL: " + response.getUrl()
                    + "; Message: " + responseMessage;

            int statusCode = response.getStatus();

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
