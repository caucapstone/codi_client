package com.example.codi;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FittingActivity extends AppCompatActivity {

    ArrayList<Integer> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fitting);

        itemList = new ArrayList<>();

        itemList.add(R.drawable.sample);
        itemList.add(R.drawable.casual5);
        itemList.add(R.drawable.pants14);

        FittingBodyAdapter bodyAdapter = new FittingBodyAdapter(itemList);

        RecyclerView bodyList = (RecyclerView) findViewById(R.id.Body_list);
        bodyList.setAdapter(bodyAdapter);
    }
}
