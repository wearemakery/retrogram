package com.getinch.retrogram.endpoints;

import com.getinch.retrogram.model.Media;
import com.getinch.retrogram.model.MediaResponse;
import com.getinch.retrogram.model.Popular;
import com.getinch.retrogram.model.SearchMediaResponse;
import retrofit.RestAdapter;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

public class MediaEndpoint extends BaseEndpoint {

    private static interface MediaService {

        @GET("/media/{media_id}")
        public MediaResponse getMedia(
            @Path("media_id") String mediaId,
            @Query("access_token") String accessToken);

        @GET("/media/search")
        public SearchMediaResponse search(
            @Query("access_token") String accessToken,
            @Query("distance") Integer distanceInKm,
            @Query("lat") Double latitude,
            @Query("lng") Double longitude,
            @Query("min_timestamp") Long minTimestamp,
            @Query("max_timestamp") Long maxTimestamp);

        @GET("/media/popular")
        public Popular getPopular(
            @Query("access_token") String accessToken);

    }

    private final MediaService mediaService;

    public MediaEndpoint(final String accessToken, final RestAdapter.LogLevel logLevel) {
        super(accessToken, logLevel);
        final RestAdapter restAdapter = new RestAdapter.Builder().setLogLevel(logLevel).setEndpoint(BASE_URL).build();
        mediaService = restAdapter.create(MediaService.class);
    }

    public Media getMedia(final String mediaId) {
        return mediaService.getMedia(mediaId, accessToken).getMedia();
    }

    public SearchMediaResponse search(final Integer distance) {
        return mediaService.search(accessToken, distance, null, null, null, null);
    }

    public SearchMediaResponse search(final Double latitude, final Double longitude) {
        return mediaService.search(accessToken, null, latitude, longitude, null, null);
    }

    public SearchMediaResponse search(final Integer distance, final Double latitude, final Double longitude, final Long minTimestamp, final Long maxTimestamp) {
        return mediaService.search(accessToken, distance, latitude, longitude, minTimestamp, maxTimestamp);
    }

    public Popular getPopular() {
        return mediaService.getPopular(accessToken);
    }

}
