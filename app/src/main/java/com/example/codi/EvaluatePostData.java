package com.example.codi;

import com.google.gson.annotations.SerializedName;

public class EvaluatePostData {
    @SerializedName("isRequest")
    private int isRequest;

    @SerializedName("userNick")
    private String userNick;

    public EvaluatePostData(int isRequest) {
        this.isRequest = isRequest;
    }

    public EvaluatePostData(int isRequest, String userNick) {
        this.isRequest = isRequest;
        this.userNick = userNick;
    }
}
