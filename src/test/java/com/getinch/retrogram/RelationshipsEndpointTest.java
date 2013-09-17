package com.getinch.retrogram;

import com.getinch.retrogram.model.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public final class RelationshipsEndpointTest extends BaseTestCase {

    @Test
    public void getFollowers() {
        final Followers followers = instagram.getRelationshipsEndpoint().getFollowers(UserId);
        for (User user : followers.getUsers()) {
            logger.info(user.getUsername());
        }
        assertNotNull(followers);
    }

    @Test
    public void getFollowedBy() {
        final FollowedBy followedBy = instagram.getRelationshipsEndpoint().getFollowedBy(UserId);
        for (User user : followedBy.getUsers()) {
            logger.info(user.getUsername());
        }
        assertNotNull(followedBy);
    }

    @Test
    public void getRequestedBy() {
        final RequestedBy requestedBy = instagram.getRelationshipsEndpoint().getRequestedBy();
        for (User user : requestedBy.getUsers()) {
            logger.info(user.getUsername());
        }
        assertNotNull(requestedBy);
    }

    @Test
    public void getRelationship() {
        final Relationship relationship = instagram.getRelationshipsEndpoint().getRelationship(UserId2);
        logger.info("target is private: {}", relationship.isTargetUserPrivate());
        logger.info("incoming status: {}", relationship.getIncomingStatus());
        logger.info("outgoing status: {}", relationship.getOutgoingStatus());
        assertNotNull(relationship);
    }

    @Test
    public void setRelationship() {
        final Relationship relationship = instagram.getRelationshipsEndpoint().setRelationship(UserId2, RelationshipAction.follow);
        logger.info("target is private: {}", relationship.isTargetUserPrivate());
        logger.info("incoming status: {}", relationship.getIncomingStatus());
        logger.info("outgoing status: {}", relationship.getOutgoingStatus());
        assertNotNull(relationship);
    }

}
