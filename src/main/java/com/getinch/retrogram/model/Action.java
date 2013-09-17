package com.getinch.retrogram.model;

public class Action {

    private String action;

    public Action(final RelationshipAction action) {
        this.action = action.toString();
    }

    public String getAction() {
        return action;
    }

}
