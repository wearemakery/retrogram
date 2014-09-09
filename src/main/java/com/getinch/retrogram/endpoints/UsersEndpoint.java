package com.getinch.retrogram.endpoints;

import com.getinch.retrogram.model.*;
import retrofit.RestAdapter;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

public final class UsersEndpoint extends BaseEndpoint {

    private static interface UserService {

        @GET("/users/{user_id}")
        public Profile getUser(
            @Path("user_id") String userId,
            @Query("access_token") String accessToken);

        @GET("/users/self/feed")
        public Feed getFeed(
            @Query("access_token") String accessToken,
            @Query("count") Integer count,
            @Query("min_id") String minId,
            @Query("max_id") String maxId);

        @GET("/users/{user_id}/media/recent")
        public Recent getRecent(
            @Path("user_id") String userId,
            @Query("access_token") String accessToken,
            @Query("count") Integer count,
            @Query("min_id") String minId,
            @Query("max_id") String maxId,
            @Query("min_timestamp") Long minTimestamp,
            @Query("max_timestamp") Long maxTimestamp);

        @GET("/users/self/media/liked")
        public Liked getLiked(
            @Query("access_token") String accessToken,
            @Query("count") Integer count,
            @Query("max_like_id") String maxLikeId);

        @GET("/users/search")
        public SearchUserResponse search(
            @Query("access_token") String accessToken,
            @Query("q") String query,
            @Query("count") Integer count);

    }

    private final UserService userService;

    public UsersEndpoint(final String accessToken, final RestAdapter.LogLevel logLevel) {
        super(accessToken, logLevel);
        final RestAdapter restAdapter = new RestAdapter.Builder().setLogLevel(logLevel).setEndpoint(BASE_URL).build();
        userService = restAdapter.create(UserService.class);
    }

    public User getSelf() {
        return userService.getUser("self", accessToken).getUser();
    }

    public User getUser(final String userId) {
        return userService.getUser(userId, accessToken).getUser();
    }

    public Feed getFeed() {
        return userService.getFeed(accessToken, null, null, null);
    }

    public Feed getFeed(final Integer count, final String minId, final String maxId) {
        return userService.getFeed(accessToken, count, minId, maxId);
    }

    public Recent getRecent(final String userId) {
        return userService.getRecent(userId, accessToken, null, null, null, null, null);
    }

    public Recent getRecent(final String userId, final Integer count, final String minId, final String maxId, final Long minTimestamp, final Long maxTimestamp) {
        return userService.getRecent(userId, accessToken, count, minId, maxId, minTimestamp, maxTimestamp);
    }

    public Liked getLiked() {
        return userService.getLiked(accessToken, null, null);
    }

    public Liked getLiked(final Integer count, final String maxLikeId) {
        return userService.getLiked(accessToken, count, maxLikeId);
    }

    public SearchUserResponse search(final String query) {
        return userService.search(accessToken, query, null);
    }

    public SearchUserResponse search(final String query, final Integer count) {
        return userService.search(accessToken, query, count);
    }

}
