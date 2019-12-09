package com.example.codi;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EvaluateActivity extends AppCompatActivity {

    RatingBar ratingBar;
    ImageView postImage;
    ImageView profileImage;
    TextView userNickname;
    TextView Tag;
    Button generalCommentBtn;
    Button recommendCommentBtn;
    Button gotoMainDisplayBtn;
    ScrollView scrollView;
    private ServiceApi service;
    LinearLayout layout;

    FragmentGeneralComment fragmentGeneralComment;
    FragmentRecommendComment fragmentRecommendComment;
    boolean generalCommentBtnPressed = false;
    //    boolean generalCommentBtnDoublePressed = false;
    boolean recommendCommentBtnPressed = false;
    //    boolean recommendCommentBtnDoublePressed = false;
//    EvaluatePostModel evaluatePostModel;
    int star;
    EvaluatePost evaluatePost;
    ArrayList<GeneralComments> generalComments;
    ArrayList<CodiComments> codiComments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluate_once);

        // TODO : Model
//        evaluatePost = evaluatePostModel.getRandomPost();
        ratingBar = (RatingBar)findViewById(R.id.ratingBar);
        postImage = (ImageView)findViewById(R.id.user_evaluate_image_iv);
        scrollView = findViewById(R.id.scrollView);
        layout = (LinearLayout)findViewById(R.id.general_comment_layout);
        generalCommentBtn = findViewById(R.id.general_comment_btn);
        recommendCommentBtn = findViewById(R.id.recommend_comment_btn);

        evaluatePost = new EvaluatePost();


        service = RetrofitClient.getClient().create(ServiceApi.class);

        gotoMainDisplayBtn = findViewById(R.id.goto_main_display_btn);
        gotoMainDisplayBtn.setVisibility(View.INVISIBLE);
        generalCommentBtn.setEnabled(false);
        recommendCommentBtn.setEnabled(false);

        //SelectPost();

        gotoMainDisplayBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), AppMainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        // inactivate scroll
        scrollView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                // TODO : Model
                // if(evaluatePost != null) {
//                    evaluatePost.setRating(rating);
//                }

                //activate scroll
                scrollView.setOnTouchListener(null);
                gotoMainDisplayBtn.setVisibility(View.VISIBLE);
                generalCommentBtn.setEnabled(true);
                recommendCommentBtn.setEnabled(true);
                //activate displaying gotoMainDisplayBtn

                // can't change rating after first setting.
                ratingBar.setIsIndicator(true);
                star = ratingBar.getNumStars();
            }
        });


        fragmentGeneralComment = new FragmentGeneralComment();
        // inflate FragmentGeneralComment
        generalCommentBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                layout.setVisibility(View.VISIBLE);
                // recommend comment button view inactivate
                if(recommendCommentBtnPressed){
                    recommendCommentBtn.setBackgroundResource(R.drawable.recommend_comment_btn_off);
                    getSupportFragmentManager().beginTransaction().remove(fragmentRecommendComment).commit();
                    recommendCommentBtnPressed = false;
//                    recommendCommentBtnDoublePressed = false;
                    recommendCommentBtn.setBackgroundResource(R.drawable.recommend_comment_btn_off);
                }

                if(generalCommentBtnPressed){
//                    if(generalCommentBtnDoublePressed) {
                    generalCommentBtnPressed = false;
//                    generalCommentBtnDoublePressed = false;
                    getSupportFragmentManager().beginTransaction().remove(fragmentGeneralComment).commit();
                    generalCommentBtn.setBackgroundResource(R.drawable.general_comment_btn_off);
//                    }
//                    else{
//                        generalCommentBtnPressed = true;
//                        generalCommentBtnDoublePressed = true;
//                    }
                }
                else{
                    generalCommentBtnPressed = true;

                    // assign responsibility to fragment manager for FragmentGeneralComment.
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, fragmentGeneralComment).commit();

                    generalCommentBtn.setBackgroundResource(R.drawable.general_comment_btn_on);
                }
            }
        });

        fragmentRecommendComment = new FragmentRecommendComment();
        // inflate FragmentRecommendComment
        recommendCommentBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                layout.setVisibility(View.VISIBLE);
                // general comment button view inactivate
                if(generalCommentBtnPressed){
                    generalCommentBtn.setBackgroundResource(R.drawable.general_comment_btn_off);
                    getSupportFragmentManager().beginTransaction().remove(fragmentGeneralComment).commit();
                    generalCommentBtnPressed = false;
//                    recommendCommentBtnDoublePressed = false;
                    generalCommentBtn.setBackgroundResource(R.drawable.general_comment_btn_off);
                }

                if(recommendCommentBtnPressed){
//                    if(generalCommentBtnDoublePressed) {
                    recommendCommentBtnPressed = false;
//                    generalCommentBtnDoublePressed = false;
                    getSupportFragmentManager().beginTransaction().remove(fragmentRecommendComment).commit();
                    recommendCommentBtn.setBackgroundResource(R.drawable.recommend_comment_btn_off);
//                    }
//                    else{
//                        generalCommentBtnPressed = true;
//                        generalCommentBtnDoublePressed = true;
//                    }
                }
                else{
                    recommendCommentBtnPressed = true;

                    // assign responsibility to fragment manager for FragmentGeneralComment.
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, fragmentRecommendComment).commit();

                    recommendCommentBtn.setBackgroundResource(R.drawable.recommend_comment_btn_on);
                }
            }
        });

    }

    private void SelectPost() {
        int req = 2;
        firstRequest(new EvaluatePostData(req));
    }

    private void firstRequest(EvaluatePostData data) {
        service.startApp(data).enqueue(new Callback<EvaluatePostResponse>() {
            @Override
            public void onResponse(Call<EvaluatePostResponse> call, Response<EvaluatePostResponse> response) {
                EvaluatePostResponse result = response.body();
                Toast.makeText(EvaluateActivity.this, result.getMessage(), Toast.LENGTH_SHORT).show();

                if (result.getCode() == 200) {
                    Intent intent = new Intent(getApplicationContext(), EvaluateOnceActivity.class);
                    startActivity(intent);
                    finish();
                }
            }

            @Override
            public void onFailure(Call<EvaluatePostResponse> call, Throwable t) {
                Toast.makeText(EvaluateActivity.this, "로그인 에러 발생", Toast.LENGTH_SHORT).show();
                Log.e("로그인 에러 발생", t.getMessage());
            }
        });
    }
}
