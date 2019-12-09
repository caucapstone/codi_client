package com.example.codi;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;

public class RecommendPostModel {
    String postID;
    File fittingImage;
    int checkNum;
    String title;
    String userNickname;
    String startDate;
    String endDate;
    String contents;

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    public void setPostID(String postID) {
        this.postID = postID;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public void setCheckNum(int checkNum) {
        this.checkNum = checkNum;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setFittingImage(File fittingImage) {
        this.fittingImage = fittingImage;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public int getCheckNum() {
        return checkNum;
    }

    public File getFittingImage() {
        return fittingImage;
    }

    public String getContents() {
        return contents;
    }

    public String getTitle() {
        return title;
    }

    public String getPostID() {
        return postID;
    }
}
