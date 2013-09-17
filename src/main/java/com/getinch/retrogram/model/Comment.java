package com.getinch.retrogram.model;

public class Comment {

    private Long created_time;
    private String text;
    private User from;
    private Long id;

    public Long getCreatedTime() {
        return created_time;
    }

    public String getText() {
        return text;
    }

    public User getFrom() {
        return from;
    }

    public Long getId() {
        return id;
    }

}
