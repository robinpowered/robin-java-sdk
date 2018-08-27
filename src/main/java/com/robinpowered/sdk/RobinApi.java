package com.robinpowered.sdk;

import com.robinpowered.sdk.credential.Credential;

import retrofit.client.Client;
import com.squareup.okhttp.HttpUrl;

import java.util.HashMap;
import java.util.Map;

/**
 * A client for interfaces with the Robin API.
 *
 * <p>
 * The API is split into several services. A particular service can be obtained by calling
 * {@code getService(ServiceInterface.class)}. For example {@code getService(AccountService.class)}.
 *
 * <p>
 * Each service requires a valid {@link Credential}, typically an
 * {@link com.robinpowered.sdk.credential.AccessTokenCredential AccessTokenCredential}. A valid API
 * token may be obtained from the <a href="https://dashboard.robinpowered.com">Web Dashboard</a>.
 *
 * <p>
 * An optional HTTP {@link Client} may be provided to perform network requests, however if none is
 * provided a {@link retrofit.client.OkClient} will be used, which simply wraps the
 * {@link com.squareup.okhttp.OkHttpClient}.
 *
 * <p>
 * Example usage:
 *
 * <pre><code>{@code  Credential credential = new AccessTokenCredential("my token");
 * RobinApi apiClient = new RobinApi(credential);
 *
 * ApiResponse<List<Presence>> presence = apiClient.getService(PlacesService.class).getPresence(mySpaceId).getData();
 * }</code></pre>
 */
public class RobinApi {

    /**
     * Properties
     */

    protected RobinServiceFactory serviceFactory = new RobinServiceFactory();
    Credential credential;
    Client httpClient;
    Map<Class<?>, Object> serviceMap = new HashMap<>();


    /**
     * Methods
     */

    /**
     * Constructor.
     */
    public RobinApi() {
    }

    /**
     * Constructor.
     *
     * @param httpClient An HTTP client for performing network requests.
     */
    public RobinApi(Client httpClient) {
        this.httpClient = httpClient;
    }

    /**
     * Constructor.
     *
     * @param httpClient An HTTP client for performing network requests.
     * @param endpoint The endpoint used to contact the API.
     */
    public RobinApi(Client httpClient, HttpUrl endpoint) {
        this.httpClient = httpClient;
        this.serviceFactory = new RobinServiceFactory(endpoint);
    }


    /**
     * Constructor.
     *
     * @param credential A credential used for authorizing with the API. This will most commonly be
     *                   an {@link com.robinpowered.sdk.credential.AccessTokenCredential
     *                   AccessTokenCredential}.
     */
    public RobinApi(Credential credential) {
        this.credential = credential;
    }

    /**
     * Constructor.
     *
     * @param credential A credential used for authorizing with the API. This will most commonly be
     *                   an {@link com.robinpowered.sdk.credential.AccessTokenCredential
     *                   AccessTokenCredential}.
     * @param httpClient An HTTP client for performing network requests.
     */
    public RobinApi(Credential credential, Client httpClient) {
        this.credential = credential;
        this.httpClient = httpClient;
    }

    /**
     * Returns an instance of a service interface.
     *
     * @see com.robinpowered.sdk.service.AccountService AccountService
     * @see com.robinpowered.sdk.service.PlacesService PlacesService
     * @see com.robinpowered.sdk.service.DeviceService DeviceService
     *
     * @param serviceInterface The service interface to return an instance of.
     * @param <ServiceType> The desired interface class reference.
     * @return An instance of the requested service.
     */
    public <ServiceType> ServiceType getService(Class<ServiceType> serviceInterface) {

        if (serviceMap.containsKey(serviceInterface)) {
            //noinspection unchecked
            return (ServiceType) serviceMap.get(serviceInterface);
        }

        ServiceType service = serviceFactory.create(serviceInterface, credential, httpClient);
        serviceMap.put(serviceInterface, service);

        return service;
    }

    /**
     * Sets the credential to use to authorize with the API.
     *
     * @param credential The credential to set.
     */
    public void setCredential(Credential credential) {
        this.credential = credential;

        // Clear the service map so that the services are recreated with the proper http interceptor
        // containing the new credential for the Authorization header.
        clearServiceCache();
    }

    /**
     * Returns the credential.
     *
     * @return The credential.
     */
    public Credential getCredential() {
        return credential;
    }

    /**
     * Returns whether a credential has been set or not.
     *
     * @return Whether a credential has been set or not.
     */
    public boolean hasCredential() {
        return credential != null;
    }

    /**
     * Resets the cache of already-instantiated services.
     */
    protected void clearServiceCache() {
        serviceMap.clear();
    }
}
