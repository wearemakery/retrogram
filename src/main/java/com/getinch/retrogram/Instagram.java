package com.getinch.retrogram;

import com.getinch.retrogram.endpoints.*;
import retrofit.RestAdapter;

import java.net.URI;
import java.net.URISyntaxException;

public final class Instagram {

    private final String accessToken;
    private final RestAdapter.LogLevel logLevel;

    private UsersEndpoint usersEndpoint;
    private RelationshipsEndpoint relationshipsEndpoint;
    private MediaEndpoint mediaEndpoint;
    private CommentsEndpoint commentsEndpoint;
    private LikesEndpoint likesEndpoint;
    private TagsEndpoint tagsEndpoint;
    private LocationsEndpoint locationsEndpoint;

    public Instagram(final String accessToken, final RestAdapter.LogLevel logLevel) {
        this.accessToken = accessToken;
        this.logLevel = logLevel;
    }

    public Instagram(final String accessToken) {
        this.accessToken = accessToken;
        this.logLevel = RestAdapter.LogLevel.NONE;
    }

    public UsersEndpoint getUsersEndpoint() {
        if (usersEndpoint == null) {
            usersEndpoint = new UsersEndpoint(accessToken, logLevel);
        }
        return usersEndpoint;
    }

    public RelationshipsEndpoint getRelationshipsEndpoint() {
        if (relationshipsEndpoint == null) {
            relationshipsEndpoint = new RelationshipsEndpoint(accessToken, logLevel);
        }
        return relationshipsEndpoint;
    }

    public MediaEndpoint getMediaEndpoint() {
        if (mediaEndpoint == null) {
            mediaEndpoint = new MediaEndpoint(accessToken, logLevel);
        }
        return mediaEndpoint;
    }

    public CommentsEndpoint getCommentsEndpoint() {
        if (commentsEndpoint == null) {
            commentsEndpoint = new CommentsEndpoint(accessToken, logLevel);
        }
        return commentsEndpoint;
    }

    public LikesEndpoint getLikesEndpoint() {
        if (likesEndpoint == null) {
            likesEndpoint = new LikesEndpoint(accessToken, logLevel);
        }
        return likesEndpoint;
    }

    public TagsEndpoint getTagsEndpoint() {
        if (tagsEndpoint == null) {
            tagsEndpoint = new TagsEndpoint(accessToken, logLevel);
        }
        return tagsEndpoint;
    }

    public LocationsEndpoint getLocationsEndpoint() {
        if (locationsEndpoint == null) {
            locationsEndpoint = new LocationsEndpoint(accessToken, logLevel);
        }
        return locationsEndpoint;
    }

    public static String requestOAuthUrl(final String clientId, final String redirectUri, final Scope... scopes) throws URISyntaxException {
        final StringBuilder urlBuilder = new StringBuilder();
        urlBuilder.append("response_type=").append("token");
        urlBuilder.append("&client_id=").append(clientId);
        urlBuilder.append("&redirect_uri=").append(redirectUri);
        if (scopes != null) {
            final StringBuilder scopeBuilder = new StringBuilder();
            for (int i = 0; i < scopes.length; i++) {
                scopeBuilder.append(scopes[i]);
                if (i < scopes.length - 1) {
                    scopeBuilder.append(' ');
                }
            }
            urlBuilder.append("&scope=").append(scopeBuilder.toString());
        }
        return new URI("https", "instagram.com", "/oauth/authorize", urlBuilder.toString(), null).toString();
    }

}
