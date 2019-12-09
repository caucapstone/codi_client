package com.example.codi;

import java.util.ArrayList;

public class RecommendBoardModel {
    ArrayList<RecommendPostModel> posts;

    public RecommendBoardModel() {
        posts = new ArrayList<>();
    }
    public void setPosts(RecommendPostModel posts) {
        this.posts.add(posts);
    }

    public RecommendPostModel getPosts(int index) {
        return posts.get(index);
    }
}
