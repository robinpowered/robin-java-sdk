package com.robinpowered.sdk.service;

import com.robinpowered.sdk.model.ApiResponse;
import com.robinpowered.sdk.model.BasicIdentifier;
import com.robinpowered.sdk.model.Device;
import com.robinpowered.sdk.model.DeviceManifest;
import com.robinpowered.sdk.model.Identifier;
import com.robinpowered.sdk.model.Space;
import com.robinpowered.sdk.model.Urn;
import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.QueryMap;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface DeviceService {

    /**
     * My Devices
     */

    // Sync
    @POST("/me/devices")
    ApiResponse<Device> addDevice(@Body Device.PostRequest device) throws IOException;

    // Async
    @POST("/me/devices")
    void addDevice(@Body Device.PostRequest device, Callback<ApiResponse<Device>> callback);


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
    @GET("/devices/{id}/space")
    ApiResponse<Space> getSpaceForDevice(@Path("id") int id, @QueryMap Map<String, Object> options) throws IOException;

    // Async
    @GET("/devices/{id}/space")
    void getSpaceForDevice(@Path("id") int id, @QueryMap Map<String, Object> options, Callback<ApiResponse<Space>> callback);

    // Sync
    @GET("/devices/{urn}/space")
    ApiResponse<Space> getSpaceForDevice(@Path("urn") Urn urn, @QueryMap Map<String, Object> options) throws IOException;

    // Async
    @GET("/devices/{urn}/space")
    void getSpaceForDevice(@Path("urn") Urn urn, @QueryMap Map<String, Object> options, Callback<ApiResponse<Space>> callback);

    // Sync
    @GET("/spaces/{id}/devices")
    ApiResponse<List<Device>> getDevicesForSpace(@Path("id") int id, @QueryMap Map<String, Object> options) throws IOException;

    // Async
    @GET("/spaces/{id}/devices")
    void getDevicesForSpace(@Path("id") int id, @QueryMap Map<String, Object> options, Callback<ApiResponse<List<Device>>> callback);

    // Sync
    @GET("/locations/{id}/devices")
    ApiResponse<List<Device>> getDevicesForLocation(@Path("id") int id, @QueryMap Map<String, Object> options) throws IOException;

    // Async
    @GET("/locations/{id}/devices")
    void getDevicesForLocation(@Path("id") int id, @QueryMap Map<String, Object> options, Callback<ApiResponse<List<Device>>> callback);

    // Sync
    @GET("/organizations/{id}/devices")
    ApiResponse<List<Device>> getDevicesForOrganization(@Path("id") int id, @QueryMap Map<String, Object> options) throws IOException;

    // Async
    @GET("/organizations/{id}/devices")
    void getDevicesForOrganization(@Path("id") int id, @QueryMap Map<String, Object> options, Callback<ApiResponse<List<Device>>> callback);


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
