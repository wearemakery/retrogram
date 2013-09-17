package com.getinch.retrogram.endpoints;

import retrofit.RestAdapter;

public abstract class BaseEndpoint {

    protected static final String BaseUrl = "https://api.instagram.com/v1";

    protected final String accessToken;
    protected final RestAdapter.LogLevel logLevel;

    protected BaseEndpoint(final String accessToken, final RestAdapter.LogLevel logLevel) {
        this.accessToken = accessToken;
        this.logLevel = logLevel;
    }

}
