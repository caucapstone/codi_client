package com.example.codi;

import com.google.gson.annotations.SerializedName;

public class JoinData {
    @SerializedName("userEmail")
    private String userEmail;

    @SerializedName("userPwd")
    private String userPwd;

    @SerializedName("userName")
    private String userName;

    @SerializedName("userNick")
    private String userNick;

    public JoinData(String userEmail, String userPwd, String userName, String userNick) {
        this.userEmail = userEmail;
        this.userPwd = userPwd;
        this.userName = userName;
        this.userNick = userNick;
    }
}
