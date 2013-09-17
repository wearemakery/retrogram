package com.getinch.retrogram;

import com.getinch.retrogram.model.Comment;
import com.getinch.retrogram.model.Comments;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class CommentsEndpointTest extends BaseTestCase {

    @Test
    public void getComments() {
        final Comments comments = instagram.getCommentsEndpoint().getComments(CommentId);
        if (comments.getComments() != null) {
            for (Comment comment : comments.getComments()) {
                logger.info("text: {}", comment.getText());
            }
        }
        assertNotNull(comments);
    }

    @Test
    public void comment() {
        // TODO should request comments access: https://docs.google.com/spreadsheet/viewform?formkey=dFNydmNsUUlEUGdySWFWbGpQczdmWnc6MQ
        assertTrue(true);
    }

    @Test
    public void delete() {
        // removed from release
        assertTrue(true);
    }

}
