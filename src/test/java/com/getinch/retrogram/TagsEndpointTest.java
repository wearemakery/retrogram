package com.getinch.retrogram;

import com.getinch.retrogram.model.Media;
import com.getinch.retrogram.model.RecentByTag;
import com.getinch.retrogram.model.SearchTagResponse;
import com.getinch.retrogram.model.TagInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class TagsEndpointTest extends BaseTestCase {

    @Test
    public void getTag() {
        final TagInfo tagInfo = instagram.getTagsEndpoint().getTag(TagName);
        logger.info("{} / {}", tagInfo.getName(), tagInfo.getMediaCount());
        assertNotNull(tagInfo);
    }

    @Test
    public void getRecent() {
        final RecentByTag recentByTag = instagram.getTagsEndpoint().getRecent(TagName);
        if (recentByTag.getMediaList() != null) {
            for (Media media : recentByTag.getMediaList()) {
                logger.info("link: {}", media.getLink());
            }
        }
        assertNotNull(recentByTag);
    }

    @Test
    public void search() {
        final SearchTagResponse response = instagram.getTagsEndpoint().search(TagName);
        if (response.getTagInfos() != null) {
            for (TagInfo tagInfo : response.getTagInfos()) {
                logger.info("{} / {}", tagInfo.getName(), tagInfo.getMediaCount());
            }
        }
        assertNotNull(response);
    }

}
