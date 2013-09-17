package com.getinch.retrogram;

import com.getinch.retrogram.model.Media;
import com.getinch.retrogram.model.Popular;
import com.getinch.retrogram.model.SearchMediaResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class MediaEndpointTest extends BaseTestCase {

    @Test
    public void getMedia() {
        final Media media = instagram.getMediaEndpoint().getMedia(MediaId);
        logger.info("link: {}", media.getLink());
        assertNotNull(media);
    }

    @Test
    public void search() {
        final SearchMediaResponse response = instagram.getMediaEndpoint().search(Longitude, Latitude);
        if (response.getMediaList() != null) {
            for (Media media : response.getMediaList()) {
                logger.info("link: {}", media.getLink());
            }
        }
        assertNotNull(response);
    }

    @Test
    public void getPopular() {
        final Popular popular = instagram.getMediaEndpoint().getPopular();
        if (popular.getMediaList() != null) {
            for (Media media : popular.getMediaList()) {
                logger.info("link: {}", media.getLink());
            }
        }
        assertNotNull(popular);
    }

}
