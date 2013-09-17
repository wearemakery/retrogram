package com.getinch.retrogram.endpoints;

import com.getinch.retrogram.model.*;
import retrofit.RestAdapter;
import retrofit.http.*;

public final class RelationshipsEndpoint extends BaseEndpoint {

    private static interface RelationshipService {

        @GET("/users/{user_id}/follows")
        public Followers getFollowers(
            @Path("user_id") String userId,
            @Query("access_token") String accessToken);

        @GET("/users/{user_id}/followed-by")
        public FollowedBy getFollowedBy(
            @Path("user_id") String userId,
            @Query("access_token") String accessToken);

        @GET("/users/self/requested-by")
        public RequestedBy getRequestedBy(
            @Query("access_token") String accessToken);

        @GET("/users/{user_id}/relationship")
        public RelationshipResponse getRelationship(
            @Path("user_id") String userId,
            @Query("access_token") String accessToken);

        @FormUrlEncoded
        @POST("/users/{user_id}/relationship")
        public RelationshipResponse postRelationship(
            @Path("user_id") String userId,
            @Field("action") String action,
            @Query("access_token") String accessToken);

    }

    private final RelationshipService relationshipService;

    public RelationshipsEndpoint(String accessToken, final RestAdapter.LogLevel logLevel) {
        super(accessToken, logLevel);
        final RestAdapter restAdapter = new RestAdapter.Builder().setLogLevel(logLevel).setServer(BaseUrl).build();
        relationshipService = restAdapter.create(RelationshipService.class);
    }

    public Followers getFollowers(final String userId) {
        return relationshipService.getFollowers(userId, accessToken);
    }

    public FollowedBy getFollowedBy(final String userId) {
        return relationshipService.getFollowedBy(userId, accessToken);
    }

    public RequestedBy getRequestedBy() {
        return relationshipService.getRequestedBy(accessToken);
    }

    public Relationship getRelationship(final String userId) {
        return relationshipService.getRelationship(userId, accessToken).getRelationship();
    }

    public Relationship setRelationship(final String userId, final RelationshipAction action) {
        return relationshipService.postRelationship(userId, action.toString(), accessToken).getRelationship();
    }

}
