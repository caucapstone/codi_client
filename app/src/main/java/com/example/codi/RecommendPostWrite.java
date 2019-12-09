package com.example.codi;

import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class RecommendPostWrite extends AppCompatActivity {
    EditText title;
    EditText startDate;
    EditText endDate;
    EditText Contents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommend_post_write);

    }
}
