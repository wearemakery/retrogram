package com.getinch.retrogram;

import junit.framework.TestCase;
import org.junit.BeforeClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit.RestAdapter;

public abstract class BaseTestCase extends TestCase {

    protected static String AccessToken;
    protected static String ClientId;
    protected static String UserId;
    protected static String UserId2;
    protected static String UserName;
    protected static String CommentId;
    protected static String MediaId;
    protected static String TagName;
    protected static String LocationId;
    protected static String RedirectUrl;

    protected static Double Latitude = 48.858844d;
    protected static Double Longitude = 2.294351d;

    protected final Logger logger;

    protected Instagram instagram;

    protected BaseTestCase() {
        instagram = new Instagram(AccessToken, RestAdapter.LogLevel.BASIC);
        logger = LoggerFactory.getLogger(getClass());
    }

    @BeforeClass
    public static void setupBeforeClass() {
        // mandatory
        AccessToken = System.getProperty("access.token");
        ClientId = System.getProperty("client.id");

        if (AccessToken == null || ClientId == null) {
            throw new RuntimeException("access.token and client.id parameters must be set, use -Daccess.token and -Dclient.id arguments");
        }

        // optional
        UserId = System.getProperty("user.id") == null ? "1574083" : System.getProperty("user.id");
        UserId2 = System.getProperty("user.id2") == null ? "3" : System.getProperty("user.id2");
        UserName = System.getProperty("user.name") == null ? "jack" : System.getProperty("user.name");
        CommentId = System.getProperty("comment.id") == null ? "555" : System.getProperty("comment.id");
        MediaId = System.getProperty("media.id") == null ? "123" : System.getProperty("media.id");
        TagName = System.getProperty("tag.name") == null ? "swag" : System.getProperty("tag.name");
        LocationId = System.getProperty("location.id") == null ? "1" : System.getProperty("location.id");
        RedirectUrl = System.getProperty("redirect.url") == null ? "http://localhost" : System.getProperty("redirect.url");

        try {
            Latitude = Double.valueOf(System.getProperty("lat"));
        } catch (final Exception e) {
            // ignore
        }
        try {
            Longitude = Double.valueOf(System.getProperty("lng"));
        } catch (final Exception e) {
            // ignore
        }

        final Logger configLogger = LoggerFactory.getLogger(BaseTestCase.class);
        configLogger.info("access token: {}", AccessToken);
        configLogger.info("client id: {}", ClientId);
        configLogger.info("user id: {}", UserId);
        configLogger.info("user id 2: {}", UserId2);
        configLogger.info("user name: {}", UserName);
        configLogger.info("comment id: {}", CommentId);
        configLogger.info("media id: {}", MediaId);
        configLogger.info("tag name: {}", TagName);
        configLogger.info("location id: {}", LocationId);
        configLogger.info("redirect url: {}", RedirectUrl);
        configLogger.info("latitude: {}", Latitude);
        configLogger.info("longitude: {}", Longitude);
    }

}
