package com.example.codi;

import com.example.codi.JoinData;
import com.example.codi.JoinResponse;
import com.example.codi.LoginData;
import com.example.codi.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ServiceApi {
        @POST("/user/login")
        Call<LoginResponse> userLogin(@Body LoginData data);

        @POST("/user/join")
        Call<JoinResponse> userJoin(@Body JoinData data);

        @POST("/user/evaluate/board")
        Call<EvaluatePostResponse> startApp(@Body EvaluatePostData data);

}
