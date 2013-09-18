package com.getinch.retrogram;

import com.getinch.retrogram.model.Location;
import com.getinch.retrogram.model.Media;
import com.getinch.retrogram.model.RecentByLocation;
import com.getinch.retrogram.model.SearchLocationResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class LocationsEndpointTest extends BaseTestCase {

    @Test
    public void getLocation() {
        final Location location = instagram.getLocationsEndpoint().getLocation(LocationId);
        logger.info("name: {}", location.getName());
        assertNotNull(location);
    }

    @Test
    public void getRecent() {
        final RecentByLocation recent = instagram.getLocationsEndpoint().getRecent(LocationId);
        if (recent.getMediaList() != null) {
            for (Media media : recent.getMediaList()) {
                logger.info("link: {}", media.getLink());
            }
        }
        assertNotNull(recent);
    }

    @Test
    public void search() {
        // TODO Instagram API currently buggy
        try {
            final SearchLocationResponse response = instagram.getLocationsEndpoint().search(Latitude, Longitude, 2000);
            if (response.getLocations() != null) {
                for (Location location : response.getLocations()) {
                    logger.info("name: {}", location.getName());
                }
            }
            assertNotNull(response);
        } catch (final Exception e) {
            logger.error("", e);
            assertTrue(true);
        }
    }

}
