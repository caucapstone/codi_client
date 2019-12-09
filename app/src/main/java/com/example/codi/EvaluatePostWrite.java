package com.example.codi;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class EvaluatePostWrite extends AppCompatActivity {
    ImageView imageView;
    Button imageBtn;
    Button saveBtn;
    EditText tags;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluate_post_write);
    }


}
