package com.robinpowered.sdk.service;

import com.robinpowered.sdk.http.DELETE;
import com.robinpowered.sdk.model.ApiResponse;
import com.robinpowered.sdk.model.Event;
import com.robinpowered.sdk.model.FreeBusySpace;
import com.robinpowered.sdk.model.User;
import retrofit.Callback;
import retrofit.http.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface EventService {

    // Sync
    @GET("/events/{eventId}")
    ApiResponse<Event> getEvent(@Path("eventId") String eventId, @QueryMap Map<String, Object> options) throws IOException;

    // Async
    @GET("/events/{eventId}")
    void getEvent(@Path("eventId") String eventId, @QueryMap Map<String, Object> options, Callback<ApiResponse<Event>> callback);

    // Sync
    @PATCH("/events/{eventId}")
    ApiResponse<Event> updateEvent(@Path("eventId") String eventId, @Body Event event) throws IOException;

    // Async
    @PATCH("/events/{eventId}")
    void updateEvent(@Path("eventId") String eventId, @Body Event event, Callback<ApiResponse<Event>> callback);

    // Sync
    @DELETE("/events/{eventId}")
    ApiResponse<Void> deleteEvent(@Path("eventId") String eventId) throws IOException;

    // Async
    @DELETE("/events/{eventId}")
    void deleteEvent(@Path("eventId") String eventId, Callback<ApiResponse<Void>> callback);

    /**
     * Confirmations
     */

    // Sync
    // Mandatory deviceId fixes crash with null bodies: https://github.com/square/retrofit/issues/854
    @PUT("/events/{eventId}/confirmation")
    ApiResponse<Event> confirmEvent(@Path("eventId") String eventId, @Body int deviceId) throws IOException;

    // Async
    // Mandatory deviceId fixes crash with null bodies: https://github.com/square/retrofit/issues/854
    @PUT("/events/{eventId}/confirmation")
    void confirmEvent(@Path("eventId") String eventId, @Body int deviceId, Callback<ApiResponse<Event>> callback);

    // Sync
    @DELETE("/events/{eventId}/confirmation")
    ApiResponse<Void> unconfirmEvent(@Path("eventId") String eventId) throws IOException;

    // Async
    @DELETE("/events/{eventId}/confirmation")
    void unconfirmEvent(@Path("eventId") String eventId, Callback<ApiResponse<Void>> callback);


    /**
     * For locations
     */

    // Sync
    @GET("/locations/{locationId}/events")
    ApiResponse<List<Event>> getLocationEvents(@Path("locationId") int locationId, @QueryMap Map<String, Object> options) throws IOException;

    // Async
    @GET("/locations/{locationId}/events")
    void getLocationEvents(@Path("locationId") int locationId, @QueryMap Map<String, Object> options, Callback<ApiResponse<List<Event>>> callback);


    /**
     * For spaces
     */

    // Sync
    @GET("/spaces/{spaceId}/events")
    ApiResponse<List<Event>> getSpaceEvents(@Path("spaceId") int spaceId, @QueryMap Map<String, Object> options) throws IOException;

    // Async
    @GET("/spaces/{spaceId}/events")
    void getSpaceEvents(@Path("spaceId") int spaceId, @QueryMap Map<String, Object> options, Callback<ApiResponse<List<Event>>> callback);

    // Sync
    @GET("/spaces/{spaceId}/events/upcoming")
    ApiResponse<List<Event>> getUpcomingSpaceEvents(@Path("spaceId") int spaceId, @QueryMap Map<String, Object> options) throws IOException;

    // Async
    @GET("/spaces/{spaceId}/events/upcoming")
    void getUpcomingSpaceEvents(@Path("spaceId") int spaceId, @QueryMap Map<String, Object> options, Callback<ApiResponse<List<Event>>> callback);

    // Sync
    @GET("/spaces/{spaceId}/events/recent")
    ApiResponse<List<Event>> getRecentSpaceEvents(@Path("spaceId") int spaceId, @QueryMap Map<String, Object> options) throws IOException;

    // Async
    @GET("/spaces/{spaceId}/events/recent")
    void getRecentSpaceEvents(@Path("spaceId") int spaceId, @QueryMap Map<String, Object> options, Callback<ApiResponse<List<Event>>> callback);

    // Sync
    @POST("/spaces/{spaceId}/events")
    ApiResponse<Event> bookSpace(@Path("spaceId") int spaceId, @Body Event.Booking eventBooking) throws IOException;

    // Async
    @POST("/spaces/{spaceId}/events")
    void bookSpace(@Path("spaceId") int spaceId, @Body Event.Booking eventBooking, Callback<ApiResponse<Event>> callback);

    // Sync
    @GET("/free-busy/spaces")
    ApiResponse<List<FreeBusySpace>> getFreeBusyForSpaces(@QueryMap Map<String, Object> options) throws IOException;

    // Async
    @GET("/free-busy/spaces")
    void getFreeBusyForSpaces(@QueryMap Map<String, Object> options, Callback<ApiResponse<List<FreeBusySpace>>> callback);


    /**
     * For users
     */

    // Sync
    @GET("/users/{id}/events")
    ApiResponse<List<Event>> getUserEvents(@Path("id") User.Reference id, @QueryMap Map<String, Object> options) throws IOException;

    // Async
    @GET("/users/{id}/events")
    void getUserEvents(@Path("id") User.Reference id, @QueryMap Map<String, Object> options, Callback<ApiResponse<List<Event>>> callback);

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
}
