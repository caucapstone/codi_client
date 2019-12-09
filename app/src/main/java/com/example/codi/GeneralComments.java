package com.example.codi;

import java.io.File;

public class GeneralComments {
    String postID;
    String Contents;
    int commentID;
    int parentID;
    int sequence;

    public GeneralComments() {}

    public void setPostID(String postID) {
        this.postID = postID;
    }

    public void setContents(String contents) {
        Contents = contents;
    }

    public void setCommentID(int commentID) {
        this.commentID = commentID;
    }

    public void setParentID(int parentID) {
        this.parentID = parentID;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public String getPostID() {
        return postID;
    }

    public String getContents() {
        return Contents;
    }

    public int getCommentID() {
        return commentID;
    }

    public int getParentID() {
        return parentID;
    }

    public int getSequence() {
        return sequence;
    }
}
