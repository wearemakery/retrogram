package com.getinch.retrogram.model;

import java.util.List;

public class Media {

    private String attribution;
    private Videos videos;
    private List<String> tags;
    private String type;
    private Location location;
    private Comments comments;
    private String filter;
    private Long created_time;
    private String link;
    private Likes likes;
    private Images images;
    private List<UserInPhoto> users_in_photo;
    private Caption caption;
    private boolean user_has_liked;
    private String id;
    private User user;

    public String getAttribution() {
        return attribution;
    }

    public List<String> getTags() {
        return tags;
    }

    public String getType() {
        return type;
    }

    public Location getLocation() {
        return location;
    }

    public Comments getComments() {
        return comments;
    }

    public String getFilter() {
        return filter;
    }

    public Long getCreatedTime() {
        return created_time;
    }

    public String getLink() {
        return link;
    }

    public Likes getLikes() {
        return likes;
    }

    public Images getImages() {
        return images;
    }

    public List<UserInPhoto> getUsersInPhoto() {
        return users_in_photo;
    }

    public Caption getCaption() {
        return caption;
    }

    public boolean userHasLiked() {
        return user_has_liked;
    }

    public String getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

}
