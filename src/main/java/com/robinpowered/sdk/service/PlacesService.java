package com.robinpowered.sdk.service;

import com.robinpowered.sdk.http.DELETE;
import com.robinpowered.sdk.model.ApiResponse;
import com.robinpowered.sdk.model.Calendar;
import com.robinpowered.sdk.model.Dibs;
import com.robinpowered.sdk.model.Event;
import com.robinpowered.sdk.model.Location;
import com.robinpowered.sdk.model.Presence;
import com.robinpowered.sdk.model.Space;
import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.QueryMap;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface PlacesService {

    /**
     * Locations
     */

    // Sync
    @GET("/locations/{id}")
    ApiResponse<Location> getLocation(@Path("id") int id, @QueryMap Map<String, Object> options) throws IOException;

    // Async
    @GET("/locations/{id}")
    void getLocation(@Path("id") int id, @QueryMap Map<String, Object> options, Callback<ApiResponse<Location>> callback);

    // Sync
    @GET("/locations/{id}/spaces")
    ApiResponse<List<Space>> getSpacesForLocation(@Path("id") int id, @QueryMap Map<String, Object> options) throws IOException;

    // Async
    @GET("/locations/{id}/spaces")
    void getSpacesForLocation(@Path("id") int id, @QueryMap Map<String, Object> options, Callback<ApiResponse<List<Space>>> callback);

    // Sync
    @GET("/locations/{id}/presence")
    ApiResponse<List<Presence>> getPresenceForLocation(@Path("id") int id, @QueryMap Map<String, Object> options) throws IOException;

    // Async
    @GET("/locations/{id}/presence")
    void getPresenceForLocation(@Path("id") int id, @QueryMap Map<String, Object> options, Callback<ApiResponse<List<Presence>>> callback);

    // Sync
    @POST("/locations/{id}/presence")
    ApiResponse<Presence> postLocationPresence(@Path("id") int id, @Body Presence.Occurrence presenceOccurrence) throws IOException;

    // Async
    @POST("/locations/{id}/presence")
    void postLocationPresence(@Path("id") int id, @Body Presence.Occurrence presenceOccurrence, Callback<ApiResponse<Presence>> callback);

    // Sync
    @DELETE("/locations/{id}/presence")
    void deleteLocationPresence(@Path("id") int id, @Body Presence.Occurrence presenceOccurrence) throws IOException;

    // Async
    @DELETE("/locations/{id}/presence")
    void deleteLocationPresence(@Path("id") int id, @Body Presence.Occurrence presenceOccurrence, Callback<ApiResponse<Presence>> callback);

    // Sync
    @GET("/locations/{locationId}/events")
    ApiResponse<List<Event>> getLocationEvents(@Path("locationId") int locationId, @QueryMap Map<String, Object> options) throws IOException;

    // Async
    @GET("/locations/{locationId}/events")
    void getLocationEvents(@Path("locationId") int locationId, @QueryMap Map<String, Object> options, Callback<ApiResponse<List<Event>>> callback);

    // Sync
    @GET("/organizations/{id}/locations")
    ApiResponse<List<Location>> getLocationsForOrganization(@Path("id") int id, @QueryMap Map<String, Object> options) throws IOException;

    // Async
    @GET("/organizations/{id}/locations")
    void getLocationsForOrganization(@Path("id") int id, @QueryMap Map<String, Object> options, Callback<ApiResponse<List<Location>>> callback);


    /**
     * Spaces
     */

    // Sync
    @GET("/spaces/{id}")
    ApiResponse<Space> getSpace(@Path("id") int id, @QueryMap Map<String, Object> options) throws IOException;

    // Async
    @GET("/spaces/{id}")
    void getSpace(@Path("id") int id, @QueryMap Map<String, Object> options, Callback<ApiResponse<Space>> callback);

    // Sync
    @GET("/spaces/{spaceId}/calendar")
    ApiResponse<Calendar> getSpaceCalendar(@Path("spaceId") int spaceId) throws IOException;

    // Async
    @GET("/spaces/{spaceId}/calendar")
    void getSpaceCalendar(@Path("spaceId") int spaceId, Callback<ApiResponse<Calendar>> callback);

    // Sync
    @GET("/spaces/{id}/presence")
    ApiResponse<List<Presence>> getPresence(@Path("id") int id, @QueryMap Map<String, Object> options) throws IOException;

    // Async
    @GET("/spaces/{id}/presence")
    void getPresence(@Path("id") int id, @QueryMap Map<String, Object> options, Callback<ApiResponse<List<Presence>>> callback);

    // Sync
    @POST("/spaces/{id}/presence")
    ApiResponse<Presence> postSpacePresence(@Path("id") int id, @Body Presence.Occurrence presenceOccurrence) throws IOException;

    // Async
    @POST("/spaces/{id}/presence")
    void postSpacePresence(@Path("id") int id, @Body Presence.Occurrence presenceOccurrence, Callback<ApiResponse<Presence>> callback);

    // Sync
    @DELETE("/spaces/{id}/presence")
    void deletePresence(@Path("id") int id, @Body Presence.Occurrence presenceOccurrence) throws IOException;

    // Async
    @DELETE("/spaces/{id}/presence")
    void deletePresence(@Path("id") int id, @Body Presence.Occurrence presenceOccurrence, Callback<ApiResponse<Presence>> callback);

    // Sync
    @GET("/spaces/{spaceId}/events")
    ApiResponse<List<Event>> getEvents(@Path("spaceId") int spaceId, @QueryMap Map<String, Object> options) throws IOException;

    // Async
    @GET("/spaces/{spaceId}/events")
    void getEvents(@Path("spaceId") int spaceId, @QueryMap Map<String, Object> options, Callback<ApiResponse<List<Event>>> callback);

    // Sync
    @GET("/spaces/{spaceId}/events/upcoming")
    ApiResponse<List<Event>> getUpcomingEvents(@Path("spaceId") int spaceId, @QueryMap Map<String, Object> options) throws IOException;

    // Async
    @GET("/spaces/{spaceId}/events/upcoming")
    void getUpcomingEvents(@Path("spaceId") int spaceId, @QueryMap Map<String, Object> options, Callback<ApiResponse<List<Event>>> callback);

    // Sync
    @GET("/spaces/{spaceId}/events/recent")
    ApiResponse<List<Event>> getRecentEvents(@Path("spaceId") int spaceId, @QueryMap Map<String, Object> options) throws IOException;

    // Async
    @GET("/spaces/{spaceId}/events/recent")
    void getRecentEvents(@Path("spaceId") int spaceId, @QueryMap Map<String, Object> options, Callback<ApiResponse<List<Event>>> callback);

    // Sync
    @POST("/spaces/{spaceId}/events")
    ApiResponse<Event> bookSpace(@Path("spaceId") int spaceId, @Body Event.Booking eventBooking) throws IOException;

    // Async
    @POST("/spaces/{spaceId}/events")
    void bookSpace(@Path("spaceId") int spaceId, @Body Event.Booking eventBooking, Callback<ApiResponse<Event>> callback);


    /**
     * Dibs
     */

    // Sync
    @GET("/spaces/{id}/dibs")
    ApiResponse<Dibs> getDibs(@Path("id") int id) throws IOException;

    // Async
    @GET("/spaces/{id}/dibs")
    void getDibs(@Path("id") int id, Callback<ApiResponse<Dibs>> callback);
}
