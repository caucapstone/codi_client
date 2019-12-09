package com.example.codi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class RecommendPostActivity extends AppCompatActivity {
//    private int a;\

    FragmentRecommendPostComment fragmentRecommendComment;
    RecommendPostModel recommendPostModel;
    TextView title;
    TextView startDate;
    TextView endDate;
    TextView checkNum;
    TextView contents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommend_post);

        // TODO : 모델로 수정해야함 int post_image가 아니라.
        Intent intent = getIntent();
        int post_image = intent.getExtras().getInt("post_image");
        recommendPostModel = new RecommendPostModel();
        recommendPostModel.setTitle("제목 졸업식날 무슨 옷 입고가야할까요?");
        recommendPostModel.setStartDate("등록일 2019-12-03");
        recommendPostModel.setEndDate("마감일 2019-12-31");
        recommendPostModel.setCheckNum(13);
        recommendPostModel.setContents("곧 있으면 졸업하는데 무슨 옷을 입어야 좋을지 모르겠어요");

        title = (TextView)findViewById(R.id.textView9);
        startDate = (TextView)findViewById(R.id.textView7);
        endDate = (TextView)findViewById(R.id.textView4);
        checkNum = (TextView)findViewById(R.id.textView11);
        contents = (TextView)findViewById(R.id.textView10);

        title.setText(recommendPostModel.getTitle());
        startDate.setText(recommendPostModel.getStartDate());
        endDate.setText(recommendPostModel.getEndDate());
        checkNum.setText("조회 " + String.valueOf(recommendPostModel.getCheckNum()));
        contents.setText(recommendPostModel.getContents());

        fragmentRecommendComment = new FragmentRecommendPostComment();

        getSupportFragmentManager().beginTransaction().replace(R.id.container2, fragmentRecommendComment).commit();

    }
//
//    // TODO : 모델로 수정해야함 int a가 아니라.
//    @Override
//    public void onRecommendPostSet(int a){
//        this.a = a;
//    }
}
