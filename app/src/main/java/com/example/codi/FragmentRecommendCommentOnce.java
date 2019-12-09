package com.example.codi;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FragmentRecommendCommentOnce extends Fragment {
    EvaluateOnceActivity activity;
    private RecyclerView recyclerview;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (EvaluateOnceActivity) getActivity();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        activity = null;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_recommend_comment, container, false);
        recyclerview = rootView.findViewById(R.id.recyclerview);
        recyclerview.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false));
        List<ExpandableListAdapter.Item> data = new ArrayList<>();

        // TODO : main comment a 인물 사진 + 닉네임 먼저 넣고 그 밑에 댓글 넣기. 추천 코디 댓글에는 사진(ImageView를 합침)이 들어갈수도 있다.
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.HEADER, "이나영"));
        // TODO : sub comment for main comment a 답글로서 등로된 인물 사진 + 닉네임 먼저 넣고 그 밑에 댓글 넣기.(또한 사진도 들어갈수 있음. 당연) 앞에 패딩 넣어서 또는 띄어쓰기 해서 + 글자 크기 작게
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "김경태"));
        // TODO : main comment b
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.HEADER, "이유리"));
        // TODO : sub comment for main comment b
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "이게 더 잘 어울릴것 같아요"));

//        // TODO : main comment c  초기에는 sub comment가 보이지 않게 하려면 이것 사용.
//        ExpandableListAdapter.Item places = new ExpandableListAdapter.Item(ExpandableListAdapter.HEADER, "Places");
//        places.invisibleChildren = new ArrayList<>();
//        places.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Kerala"));
//        places.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Tamil Nadu"));
//        places.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Karnataka"));
//        places.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "Maharashtra"));

//        data.add(places);

        recyclerview.setAdapter(new ExpandableListAdapter(data));

        return rootView;
    }
}
