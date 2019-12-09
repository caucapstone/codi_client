package com.example.codi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EvaluateOnceActivity extends AppCompatActivity {

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
    Bitmap bitmap;

    FragmentGeneralCommentOnce fragmentGeneralComment;
    FragmentRecommendCommentOnce fragmentRecommendComment;
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
        evaluatePost.setUserNickname("kkt752");
        evaluatePost.setTags("#캐주얼한 #상큼한 #멋있는");
        evaluatePost.setCheckNum(32);

        service = RetrofitClient.getClient().create(ServiceApi.class);

        gotoMainDisplayBtn = findViewById(R.id.goto_main_display_btn);
        gotoMainDisplayBtn.setVisibility(View.INVISIBLE);
        generalCommentBtn.setEnabled(false);
        recommendCommentBtn.setEnabled(false);

        //startApplication();

        gotoMainDisplayBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), AppMainActivity.class);
                startActivity(intent);
                finish();
            }
        });



/*
        Thread mThread = new Thread() {
            @Override
            public void run() {
                try {
                    URL url = new URL("http://www.gettyimagesgallery.com/Images/Exhibitions/Poolside/01.jpg");

                    // Web에서 이미지를 가져온 뒤
                    // ImageView에 지정할 Bitmap을 만든다
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setDoInput(true); // 서버로 부터 응답 수신
                    conn.connect();

                    InputStream is = conn.getInputStream(); // InputStream 값 가져오기
                    bitmap = BitmapFactory.decodeStream(is); // Bitmap으로 변환

                } catch (MalformedURLException e) {
                    e.printStackTrace();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };

        mThread.start(); // Thread 실행

        try {
            // 메인 Thread는 별도의 작업 Thread가 작업을 완료할 때까지 대기해야한다
            // join()를 호출하여 별도의 작업 Thread가 종료될 때까지 메인 Thread가 기다리게 한다
            mThread.join();

            // 작업 Thread에서 이미지를 불러오는 작업을 완료한 뒤
            // UI 작업을 할 수 있는 메인 Thread에서 ImageView에 이미지를 지정한다
            postImage.setImageBitmap(bitmap);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
*/


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

                //activate displaying gotoMainDisplayBtn
                gotoMainDisplayBtn.setVisibility(View.VISIBLE);
                generalCommentBtn.setEnabled(true);
                recommendCommentBtn.setEnabled(true);
                // can't change rating after first setting.
                ratingBar.setIsIndicator(true);
                star = ratingBar.getNumStars();
            }
        });


        fragmentGeneralComment = new FragmentGeneralCommentOnce();
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

        fragmentRecommendComment = new FragmentRecommendCommentOnce();
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

    private void startApplication() {
        int req = 1;
        firstRequest(new EvaluatePostData(req));
    }

    private void firstRequest(EvaluatePostData data) {
        service.startApp(data).enqueue(new Callback<EvaluatePostResponse>() {
            @Override
            public void onResponse(Call<EvaluatePostResponse> call, Response<EvaluatePostResponse> response) {
                EvaluatePostResponse result = response.body();
                Toast.makeText(EvaluateOnceActivity.this, result.getMessage(), Toast.LENGTH_SHORT).show();

                if (result.getCode() == 200) {
                    Intent intent = new Intent(getApplicationContext(), EvaluateOnceActivity.class);
                    startActivity(intent);
                    finish();
                }
            }

            @Override
            public void onFailure(Call<EvaluatePostResponse> call, Throwable t) {
                Toast.makeText(EvaluateOnceActivity.this, "서버 통신 에러 발생", Toast.LENGTH_SHORT).show();
                Log.e("서버 통신 에러 발생", t.getMessage());
            }
        });
    }
}
