package com.example.codi;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class EvaluatePostModel {
//    HashMap<String, ArrayList<EvaluatePost>> posts;
    ArrayList<EvaluatePost> posts;

    public EvaluatePostModel(){
        posts = new ArrayList<>();
    }

    public void setPosts(EvaluatePost posts) {
        this.posts.add(posts);
    }

    public EvaluatePost getPosts(int index) {
        return posts.get(index);
    }
}

class EvaluatePost{

    String postID;
    String userNickname;
    File profile;
    String date;
    File postImage;
    String tags;
    int CheckNum;
    float rating;


    public EvaluatePost() {}

    public void setPostID(String postID) {
        this.postID = postID;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    public void setProfile(File profile) {
        this.profile = profile;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setPostImage(File postImage) {
        this.postImage = postImage;
    }

    public void setCheckNum(int checkNum) {
        CheckNum = checkNum;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public void setRating(float rating){
        this.rating = rating;
    }

    public String getDate() {
        return date;
    }

    public File getPostImage() {
        return postImage;
    }

    public float getRating() {
        return rating;
    }

    public int getCheckNum() {
        return CheckNum;
    }

    public String getTags() {
        return tags;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public File getProfile() {
        return profile;
    }

    public String getPostID() {
        return postID;
    }
}
