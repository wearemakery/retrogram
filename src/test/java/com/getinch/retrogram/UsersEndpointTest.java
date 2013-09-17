package com.getinch.retrogram;

import com.getinch.retrogram.model.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public final class UsersEndpointTest extends BaseTestCase {

    @Test
    public void getProfile() {
        final User user = instagram.getUsersEndpoint().getUser(UserId);
        logger.info("bio: {}", user.getBio());
        logger.info("full name: {}", user.getFullName());
        logger.info("id: {}", user.getId());
        logger.info("profile picture: {}", user.getProfilePicture());
        logger.info("profile name: {}", user.getUsername());
        logger.info("website: {}", user.getWebsite());
        assertNotNull(user);
    }

    @Test
    public void getFeed() {
        final Feed feed = instagram.getUsersEndpoint().getFeed(1, null, null);
        if (feed.getMediaList() != null) {
            for (Media media : feed.getMediaList()) {
                logger.info("link: {}", media.getLink());
            }
        }
        assertNotNull(feed);
    }

    @Test
    public void getRecent() {
        final Recent recent = instagram.getUsersEndpoint().getRecent(UserId, 1, null, null, null, null);
        if (recent.getMediaList() != null) {
            for (Media media : recent.getMediaList()) {
                logger.info("link: {}", media.getLink());
            }
        }
        assertNotNull(recent);
    }

    @Test
    public void getLiked() {
        final Liked liked = instagram.getUsersEndpoint().getLiked(1, null);
        if (liked.getMediaList() != null) {
            for (Media media : liked.getMediaList()) {
                logger.info("link: {}", media.getLink());
            }
        }
        assertNotNull(liked);
    }

    @Test
    public void search() {
        final SearchUserResponse searchResponse = instagram.getUsersEndpoint().search(UserName);
        if (searchResponse.getUsers() != null) {
            for (User user : searchResponse.getUsers()) {
                logger.info("username: {}", user.getUsername());
            }
        }
    }

}
