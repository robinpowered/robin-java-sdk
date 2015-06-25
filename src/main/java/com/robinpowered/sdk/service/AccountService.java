package com.robinpowered.sdk.service;

import com.robinpowered.sdk.model.ApiResponse;
import com.robinpowered.sdk.model.Event;
import com.robinpowered.sdk.model.Organization;
import com.robinpowered.sdk.model.Presence;
import com.robinpowered.sdk.model.User;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.QueryMap;

public interface AccountService {

    /**
     * Users
     */

    // Sync
    @GET("/users/{id}")
    ApiResponse<User> getUser(@Path("id") int id, @QueryMap Map<String, Object> options) throws IOException;

    // Async
    @GET("/users/{id}")
    void getUser(@Path("id") int id, @QueryMap Map<String, Object> options, Callback<ApiResponse<User>> callback);

    // Sync
    @GET("/users/{id}/presence")
    ApiResponse<List<Presence>> getUserPresence(@Path("id") int id, @QueryMap Map<String, Object> options) throws IOException;

    // Async
    @GET("/users/{id}/presence")
    void getUserPresence(@Path("id") int id, @QueryMap Map<String, Object> options, Callback<ApiResponse<List<Presence>>> callback);

    // Sync
    @GET("/users/{id}/events")
    ApiResponse<List<Event>> getUserEvents(@Path("id") int id, @QueryMap Map<String, Object> options) throws IOException;

    // Async
    @GET("/users/{id}/events")
    void getUserEvents(@Path("id") int id, @QueryMap Map<String, Object> options, Callback<ApiResponse<List<Event>>> callback);


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

    // Sync
    @GET("/me/events")
    ApiResponse<List<Event>> getMyEvents(@QueryMap Map<String, Object> options) throws IOException;

    // Async
    @GET("/me/events")
    void getMyEvents(@QueryMap Map<String, Object> options, Callback<ApiResponse<List<Event>>> callback);

    // Sync
    @GET("/me/events/upcoming")
    ApiResponse<List<Event>> getMyUpcomingEvents(@QueryMap Map<String, Object> options) throws IOException;

    // Async
    @GET("/me/events/upcoming")
    void getMyUpcomingEvents(@QueryMap Map<String, Object> options, Callback<ApiResponse<List<Event>>> callback);

    // Sync
    @GET("/me/events/recent")
    ApiResponse<List<Event>> getMyRecentEvents(@QueryMap Map<String, Object> options) throws IOException;

    // Async
    @GET("/me/events/recent")
    void getMyRecentEvents(@QueryMap Map<String, Object> options, Callback<ApiResponse<List<Event>>> callback);


    /**
     * Organizations
     */

    // Sync
    @GET("/organizations/{id}")
    ApiResponse<Organization> getOrganization(@Path("id") int id, @QueryMap Map<String, Object> options) throws IOException;

    // Async
    @GET("/organizations/{id}")
    void getOrganization(@Path("id") int id, @QueryMap Map<String, Object> options, Callback<ApiResponse<Organization>> callback);

    // Sync
    @GET("/organizations/{id}/users")
    ApiResponse<List<User>> getOrganizationUsers(@Path("id") int id, @QueryMap Map<String, Object> options) throws IOException;

    // Async
    @GET("/organizations/{id}/users")
    void getOrganizationUsers(@Path("id") int id, @QueryMap Map<String, Object> options, Callback<ApiResponse<List<User>>> callback);
}
