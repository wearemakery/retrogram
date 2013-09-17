package com.getinch.retrogram.model;


public class Relationship {

    private boolean target_user_is_private;
    private OutgoingStatus outgoing_status;
    private IncomingStatus incoming_status;

    public boolean isTargetUserPrivate() {
        return target_user_is_private;
    }

    public OutgoingStatus getOutgoingStatus() {
        return outgoing_status;
    }

    public IncomingStatus getIncomingStatus() {
        return incoming_status;
    }

    public static enum OutgoingStatus {

        follows, requested, none

    }

    public static enum IncomingStatus {

        followed_by, requested_by, blocked_by_you, none

    }

}
