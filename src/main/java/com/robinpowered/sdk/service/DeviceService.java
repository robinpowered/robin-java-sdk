package com.robinpowered.sdk.service;

import com.robinpowered.sdk.model.ApiResponse;
import com.robinpowered.sdk.model.Device;
import com.robinpowered.sdk.model.DeviceManifest;
import com.robinpowered.sdk.model.Identifier;
import com.robinpowered.sdk.model.Space;
import com.robinpowered.sdk.model.Urn;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.QueryMap;

public interface DeviceService {

    /**
     * My Devices
     */

    // Sync
    @POST("/me/devices")
    ApiResponse<Device> addDevice(@Body Device device) throws IOException;

    // Async
    @POST("/me/devices")
    void addDevice(@Body Device device, Callback<ApiResponse<Device>> callback);


    /**
     * Devices
     */

    // Sync
    @GET("/devices/{id}")
    ApiResponse<Device> getDevice(@Path("id") int id, @QueryMap Map<String, Object> options) throws IOException;

    // Async
    @GET("/devices/{id}")
    void getDevice(@Path("id") int id, @QueryMap Map<String, Object> options, Callback<ApiResponse<Device>> callback);

    // Sync
    @GET("/devices/{id}")
    ApiResponse<Device> getDevice(@Path("id") String id, @QueryMap Map<String, Object> options) throws IOException;

    // Async
    @GET("/devices/{id}")
    void getDevice(@Path("id") String id, @QueryMap Map<String, Object> options, Callback<ApiResponse<Device>> callback);

    // Sync
    @POST("/devices/{id}/identifiers")
    ApiResponse<Identifier> addIdentifierToDevice(@Path("id") int id, @Body Identifier identifier) throws IOException;

    // Async
    @POST("/devices/{id}/identifiers")
    void addIdentifierToDevice(@Path("id") int id, @Body Identifier identifier, Callback<ApiResponse<Identifier>> callback);

    // Sync
    @GET("/devices/{id}/spaces")
    ApiResponse<List<Space>> getSpacesForDevice(@Path("id") int id, @QueryMap Map<String, Object> options) throws IOException;

    // Async
    @GET("/devices/{id}/spaces")
    void getSpacesForDevice(@Path("id") int id, @QueryMap Map<String, Object> options, Callback<ApiResponse<List<Space>>> callback);

    // Sync
    @GET("/devices/{urn}/spaces")
    ApiResponse<List<Space>> getSpacesForDevice(@Path("urn") Urn urn, @QueryMap Map<String, Object> options) throws IOException;

    // Async
    @GET("/devices/{urn}/spaces")
    void getSpacesForDevice(@Path("urn") Urn urn, @QueryMap Map<String, Object> options, Callback<ApiResponse<List<Space>>> callback);


    /**
     * Device Manifests
     */

    // Sync
    @GET("/device-manifests")
    ApiResponse<List<DeviceManifest>> getDeviceManifests(@QueryMap Map<String, Object> options) throws IOException;

    // Async
    @GET("/device-manifests")
    void getDeviceManifests(@QueryMap Map<String, Object> options, Callback<ApiResponse<List<DeviceManifest>>> callback);

    // Sync
    @GET("/device-manifests/{id}")
    ApiResponse<DeviceManifest> getDeviceManifest(@Path("id") int id, @QueryMap Map<String, Object> options) throws IOException;

    // Async
    @GET("/device-manifests/{id}")
    void getDeviceManifest(@Path("id") int id, @QueryMap Map<String, Object> options, Callback<ApiResponse<DeviceManifest>> callback);

    // Sync
    @GET("/device-manifests/{slug}")
    ApiResponse<DeviceManifest> getDeviceManifest(@Path("slug") String slug, @QueryMap Map<String, Object> options) throws IOException;

    // Async
    @GET("/device-manifests/{slug}")
    void getDeviceManifest(@Path("slug") String slug, @QueryMap Map<String, Object> options, Callback<ApiResponse<DeviceManifest>> callback);
}
