package com.getinch.retrogram.model;

public class Pagination {

    private String next_url;
    private String next_min_id;
    private String next_max_id;
    private String next_min_tag_id;
    private String next_max_tag_id;
    private String next_cursor;


    public String getNextUrl() {
        return next_url;
    }

    public String getNextMinId() {
        return next_min_id;
    }

    public String getNextMaxId() {
        return next_max_id;
    }

    public String getNextMinTagId() {
        return next_min_tag_id;
    }

    public String getNextMaxTagId() {
        return next_max_tag_id;
    }

    public String getNextCursor() {
        return next_cursor;
    }

}
