package com.getinch.retrogram.endpoints;

import com.getinch.retrogram.model.Location;
import com.getinch.retrogram.model.LocationResponse;
import com.getinch.retrogram.model.RecentByLocation;
import com.getinch.retrogram.model.SearchLocationResponse;
import retrofit.RestAdapter;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

public class LocationsEndpoint extends BaseEndpoint {

    private static interface LocationsService {

        @GET("/locations/{location_id}")
        public LocationResponse getLocation(
            @Path("location_id") String locationId,
            @Query("access_token") String accessToken);

        @GET("/locations/{location_id}/media/recent")
        public RecentByLocation getRecent(
            @Path("location_id") String locationId,
            @Query("access_token") String accessToken,
            @Query("min_id") String minId,
            @Query("max_id") String maxId,
            @Query("min_timestamp") Long minTimestamp,
            @Query("max_timestamp") Long maxTimestamp);

        @GET("/locations/search")
        public SearchLocationResponse search(
            @Query("access_token") String accessToken,
            @Query("lat") Double latitude,
            @Query("lng") Double longitude,
            @Query("distance") Integer distance,
            @Query("foursquare_v2_id") String foursquareV2Id,
            @Query("foursquare_id") String foursquareId);

    }

    private final LocationsService locationsService;

    public LocationsEndpoint(final String accessToken, final RestAdapter.LogLevel logLevel) {
        super(accessToken, logLevel);
        final RestAdapter restAdapter = new RestAdapter.Builder().setLogLevel(logLevel).setServer(BaseUrl).build();
        locationsService = restAdapter.create(LocationsService.class);
    }

    public Location getLocation(final String locationId) {
        return locationsService.getLocation(locationId, accessToken).getLocation();
    }

    public RecentByLocation getRecent(final String locationId) {
        return locationsService.getRecent(locationId, accessToken, null, null, null, null);
    }

    public RecentByLocation getRecent(final String locationId, final String minId, final String maxId, final Long minTimestamp, final Long maxTimestamp) {
        return locationsService.getRecent(locationId, accessToken, minId, maxId, minTimestamp, maxTimestamp);
    }

    public SearchLocationResponse search(final Double latitude, final Double longitude) {
        return locationsService.search(accessToken, latitude, longitude, null, null, null);
    }

    public SearchLocationResponse search(final Double latitude, final Double longitude, final Integer distance) {
        return locationsService.search(accessToken, latitude, longitude, distance, null, null);
    }

    public SearchLocationResponse search(final String foursquareId, final boolean isV2) {
        return locationsService.search(accessToken, null, null, null, isV2 ? foursquareId : null, isV2 ? null : foursquareId);
    }

}
