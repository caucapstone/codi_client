package com.example.codi;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class FragmentRecommendBoard extends Fragment {
    ArrayList<Integer> posts;
    RecommendBoardModel recommend;
    FloatingActionButton writeBtn;
//    private OnFragmentInteractionListener mListener;
//    OnRecommendPostSetListener onRecommendPostSetListener;
    public FragmentRecommendBoard() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View thisFragmentView = inflater.inflate(R.layout.fragment_recommend_board, container, false);
        writeBtn = (FloatingActionButton) thisFragmentView.findViewById(R.id.fab_rec_main);

        recommend = new RecommendBoardModel();
        recommend.setPosts(new RecommendPostModel());
        recommend.getPosts(0);


        posts = new ArrayList<>();
        for(int i = 0; i <= 10; i++){
            // TODO : Post image + 제목 + 정보들 모델. <Integer>가 아닌 모델이 들어가야 함.
            posts.add(R.drawable.user_image);
        }


        writeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), RecommendPostWrite.class);
                startActivity(intent);
            }
        });

        // 커스텀 아답타 생성
        GridviewAdapter adapter = new GridviewAdapter (
                getContext(),
                R.layout.recommend_board_griditem,       // GridView 항목의 레이아웃
                posts);    // 데이터

        GridView gv = (GridView)thisFragmentView.findViewById(R.id.gridView1);
        gv.setAdapter(adapter);  // 커스텀 아답타를 GridView 에 적용

        // GridView 아이템을 클릭하면 상단 텍스트뷰에 position 출력
        // JAVA8 에 등장한 lambda expression 으로 구현했습니다. 코드가 많이 간결해지네요
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
//                onRecommendPostSetListener = new RecommendPostActivity();
//                onRecommendPostSetListener.onRecommendPostSet(posts.get(position));

                // TODO : Post image + 제목 + 정보들 모델. <Integer>가 아닌 모델이 들어가야 함.
                Intent intent = new Intent(getActivity(), RecommendPostActivity.class);
                intent.putExtra("post_image", posts.get(position));
                startActivity(intent);
            }
        });

        // Inflate the layout for this fragment
        return thisFragmentView;
    }

//    public interface OnRecommendPostSetListener {
//        // TODO : 모델로 수정해야함 int a가 아니라.
//        void onRecommendPostSet(int a);
//    }
//    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }
//
//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mListener = null;
//    }
//
//    /**
//     * This interface must be implemented by activities that contain this
//     * fragment to allow an interaction in this fragment to be communicated
//     * to the activity and potentially other fragments contained in that
//     * activity.
//     * <p>
//     * See the Android Training lesson <a href=
//     * "http://developer.android.com/training/basics/fragments/communicating.html"
//     * >Communicating with Other Fragments</a> for more information.
//     */
//    public interface OnFragmentInteractionListener {
//        // TODO: Update argument type and name
//        void onFragmentInteraction(Uri uri);
//    }
}
