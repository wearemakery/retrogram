package com.getinch.retrogram;

import com.getinch.retrogram.model.Likes;
import com.getinch.retrogram.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class LikesEndpointTest extends BaseTestCase {

    @Test
    public void getLikes() {
        final Likes likes = instagram.getLikesEndpoint().getLikes(MediaId);
        if (likes.getUsers() != null) {
            for (User user : likes.getUsers()) {
                logger.info("username: {}", user.getUsername());
            }
        }
    }

    @Test
    public void like() {
        final boolean result = instagram.getLikesEndpoint().like(MediaId);
        assertTrue(result);
    }

    @Test
    public void unlike() {
        final boolean result = instagram.getLikesEndpoint().unlike(MediaId);
        assertTrue(result);
    }

}
