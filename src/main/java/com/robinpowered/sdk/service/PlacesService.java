package com.robinpowered.sdk.service;

import com.robinpowered.sdk.http.DELETE;
import com.robinpowered.sdk.model.Amenity;
import com.robinpowered.sdk.model.ApiResponse;
import com.robinpowered.sdk.model.Calendar;
import com.robinpowered.sdk.model.Location;
import com.robinpowered.sdk.model.Organization;
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
    ApiResponse<Void> deleteLocationPresence(@Path("id") int id, @Body Presence.Occurrence presenceOccurrence) throws IOException;

    // Async
    @DELETE("/locations/{id}/presence")
    void deleteLocationPresence(@Path("id") int id, @Body Presence.Occurrence presenceOccurrence, Callback<ApiResponse<Void>> callback);

    // Sync
    @GET("/organizations/{id}/locations")
    ApiResponse<List<Location>> getLocationsForOrganization(@Path("id") Organization.Reference id, @QueryMap Map<String, Object> options) throws IOException;

    // Async
    @GET("/organizations/{id}/locations")
    void getLocationsForOrganization(@Path("id") Organization.Reference id, @QueryMap Map<String, Object> options, Callback<ApiResponse<List<Location>>> callback);


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
    ApiResponse<Void> deletePresence(@Path("id") int id, @Body Presence.Occurrence presenceOccurrence) throws IOException;

    // Async
    @DELETE("/spaces/{id}/presence")
    void deletePresence(@Path("id") int id, @Body Presence.Occurrence presenceOccurrence, Callback<ApiResponse<Void>> callback);

    // Sync
    @GET("/spaces/{id}/amenities")
    ApiResponse<List<Amenity>> getAmenities(@Path("id") int id, @QueryMap Map<String, Object> options) throws IOException;

    // Async
    @GET("/spaces/{id}/amenities")
    void getAmenities(@Path("id") int id, @QueryMap Map<String, Object> options, Callback<ApiResponse<List<Amenity>>> callback);
}
