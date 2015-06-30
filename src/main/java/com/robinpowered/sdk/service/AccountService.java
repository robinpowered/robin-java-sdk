package com.robinpowered.sdk.service;

import com.robinpowered.sdk.model.ApiResponse;
import com.robinpowered.sdk.model.Organization;
import com.robinpowered.sdk.model.Presence;
import com.robinpowered.sdk.model.User;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.QueryMap;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface AccountService {

    /**
     * Users
     */

    // Sync

    @GET("/users/{id}")
    ApiResponse<User> getUser(@Path("id") User.Reference id, @QueryMap Map<String, Object> options) throws IOException;

    // Async
    @GET("/users/{id}")
    void getUser(@Path("id") User.Reference id, @QueryMap Map<String, Object> options, Callback<ApiResponse<User>> callback);

    // Sync
    @GET("/users/{id}/presence")
    ApiResponse<List<Presence>> getUserPresence(@Path("id") User.Reference id, @QueryMap Map<String, Object> options) throws IOException;

    // Async
    @GET("/users/{id}/presence")
    void getUserPresence(@Path("id") User.Reference id, @QueryMap Map<String, Object> options, Callback<ApiResponse<List<Presence>>> callback);


    /**
     * Current user
     */

    // Sync
    @GET("/me")
    ApiResponse<User> getMe() throws IOException;

    // Async
    @GET("/me")
    void getMe(Callback<ApiResponse<User>> callback);

    // Sync
    @GET("/me/organizations")
    ApiResponse<List<Organization>> getMyOrganizations(@QueryMap Map<String, Object> options) throws IOException;

    // Async
    @GET("/me/organizations")
    void getMyOrganizations(@QueryMap Map<String, Object> options, Callback<ApiResponse<List<Organization>>> callback);


    /**
     * Organizations
     */

    // Sync
    @GET("/organizations/{id}")
    ApiResponse<Organization> getOrganization(@Path("id") Organization.Reference id, @QueryMap Map<String, Object> options) throws IOException;

    // Async
    @GET("/organizations/{id}")
    void getOrganization(@Path("id") Organization.Reference id, @QueryMap Map<String, Object> options, Callback<ApiResponse<Organization>> callback);

    // Sync
    @GET("/organizations/{id}/users")
    ApiResponse<List<User>> getOrganizationUsers(@Path("id") Organization.Reference id, @QueryMap Map<String, Object> options) throws IOException;

    // Async
    @GET("/organizations/{id}/users")
    void getOrganizationUsers(@Path("id") Organization.Reference id, @QueryMap Map<String, Object> options, Callback<ApiResponse<List<User>>> callback);
}
