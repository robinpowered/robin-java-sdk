package com.robinpowered.sdk;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.robinpowered.sdk.credential.Credential;
import com.robinpowered.sdk.exception.RobinExceptionHandler;
import com.robinpowered.sdk.model.Urn;
import com.robinpowered.sdk.model.adapter.JodaDateTimeAdapter;
import com.robinpowered.sdk.model.adapter.RobinTypeAdapterFactory;
import com.robinpowered.sdk.model.adapter.UrnAdapter;
import com.squareup.okhttp.HttpUrl;
import org.joda.time.DateTime;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.client.Client;
import retrofit.converter.Converter;
import retrofit.converter.GsonConverter;

/**
 * Factory class to create and return services created by {@link retrofit.RestAdapter}.
 */
public class RobinServiceFactory {

    /**
     * Constants
     */

    public static final String BASE_URL = "https://api.robinpowered.com/v1.0";


    /**
     * Properties
     */

    HttpUrl endpoint;

    public RobinServiceFactory() {
        this(HttpUrl.parse(BASE_URL));
    }

    public RobinServiceFactory(HttpUrl endpoint) {
        this.endpoint = endpoint;
    }

    /**
     * Private helpers
     */

    /**
     * Returns a {@link Converter} configured to deserialize Robin entities.
     *
     * @return A converter.
     */
    protected Converter getResponseDataConverter() {
        Gson gson = new GsonBuilder()

                // Set our naming policy to transform underscores <-> camelCase
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .registerTypeAdapter(DateTime.class, new JodaDateTimeAdapter())
                .registerTypeAdapterFactory(new RobinTypeAdapterFactory())
                .registerTypeAdapter(Urn.class, new UrnAdapter())
                .serializeNulls()

                .create();

        return new GsonConverter(gson);
    }

    /**
     * Returns a {@link retrofit.RestAdapter.Builder} pre-configured with a {@link GsonConverter}
     * and a {@link RobinExceptionHandler}.
     *
     * @return The builder.
     */
    protected RestAdapter.Builder getRestAdapterBuilder() {
        RestAdapter.Builder builder = new RestAdapter.Builder();

        builder.setConverter(getResponseDataConverter());
        builder.setErrorHandler(new RobinExceptionHandler());

        return builder;
    }

    /**
     * Public Factories
     */

    /**
     * Factory method to create and return a Robin API Service.
     *
     * @param serviceType The service class type to create.
     * @return The Robin service.
     */
    <ServiceType> ServiceType create(Class<ServiceType> serviceType) {
        return create(serviceType, null);
    }

    /**
     * Factory method to create and return a Robin API Service with the provided auth credential.
     *
     * @param serviceType The service class type to create.
     * @param credential A credential used to authorize and authenticate with the service.
     * @return The Robin service.
     */
    <ServiceType> ServiceType create(Class<ServiceType> serviceType,
            final Credential credential) {

        return create(serviceType, credential, null);
    }

    /**
     * Factory method to create and return a Robin API Service with the provided auth credential
     * and http client.
     *
     * @param serviceType The service class type to create.
     * @param credential A credential used to authorize and authenticate with the service.
     * @param httpClient The http client to use for network requests.
     * @return The Robin service.
     */
    <ServiceType> ServiceType create(Class<ServiceType> serviceType,
            final Credential credential, final Client httpClient) {

        return create(serviceType, credential, httpClient, endpoint);
    }

    /**
     * Factory method to create and return a Robin API Service with the provided auth credential
     * and http client.
     *
     * @param serviceType The service class type to create.
     * @param credential A credential used to authorize and authenticate with the service.
     * @param httpClient The http client to use for network requests.
     * @return The Robin service.
     */
    <ServiceType> ServiceType create(Class<ServiceType> serviceType,
            final Credential credential, final Client httpClient, final HttpUrl endpoint) {

        RestAdapter.Builder restAdapterBuilder = getRestAdapterBuilder();

        if (httpClient != null) {
            restAdapterBuilder.setClient(httpClient);
        }

        restAdapterBuilder.setEndpoint(endpoint.toString());

        restAdapterBuilder.setRequestInterceptor(
                new RequestInterceptor() {
                    @Override
                    public void intercept(RequestFacade request) {
                        if (null != credential) {
                            // The existing Authorization header will not be replaced if it
                            // already exists.
                            request.addHeader("Authorization", credential.getBuiltValue());
                        }
                    }
                }
        );

        return restAdapterBuilder.build().create(serviceType);
    }
}
