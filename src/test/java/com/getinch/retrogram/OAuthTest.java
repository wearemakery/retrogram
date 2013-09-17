package com.getinch.retrogram;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.net.URISyntaxException;

@RunWith(JUnit4.class)
public final class OAuthTest extends BaseTestCase {

    @Test
    public void requestOAuthUrl() throws URISyntaxException {
        final String oAuthUrl = Instagram.requestOAuthUrl(ClientId, RedirectUrl, null);
        logger.info("OAuth url: {}", oAuthUrl);
        assertNotNull(oAuthUrl);
    }

    @Test
    public void requestOAuthUrlWithScopes() throws URISyntaxException {
        final String oAuthUrl = Instagram.requestOAuthUrl(ClientId, RedirectUrl, Scope.basic, Scope.comments, Scope.likes, Scope.relationships);
        logger.info("OAuth url with scopes: {}", oAuthUrl);
        assertNotNull(oAuthUrl);
    }

}
