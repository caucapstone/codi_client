package com.example.codi;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {
    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("userEmail")
    private int userEmail;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public int getUserEmail() {
        return userEmail;
    }
}
