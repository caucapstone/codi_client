package com.example.codi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

class GridviewAdapter extends BaseAdapter {
    Context context;
    int layout;
    ArrayList<Integer> posts;
    RecommendPostModel recommend;
    EvaluatePost evaluate;
    LayoutInflater inf;


    public GridviewAdapter(Context context, int layout, ArrayList<Integer> posts) {
        this.context = context;
        this.layout = layout;
        this.posts = posts;
        inf = (LayoutInflater) context.getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
    }

    public GridviewAdapter(Context context, int layout, EvaluatePost evaluate) {
        this.context = context;
        this.layout = layout;
        this.evaluate = evaluate;
        inf = (LayoutInflater) context.getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
    }

    public GridviewAdapter(Context context, int layout, RecommendPostModel recommend) {
        this.context = context;
        this.layout = layout;
        this.recommend = recommend;
        inf = (LayoutInflater) context.getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return posts.size();
    }

    @Override
    public Object getItem(int position) {
        return posts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null)
            convertView = inf.inflate(layout, null);
        ImageView iv = (ImageView)convertView.findViewById(R.id.imageView1);
        iv.setImageResource(posts.get(position));

        return convertView;
    }
}
