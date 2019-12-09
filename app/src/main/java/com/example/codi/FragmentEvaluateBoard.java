package com.example.codi;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class FragmentEvaluateBoard extends Fragment {
    ArrayList<Integer> posts;
    EvaluatePostModel postModel;
    FloatingActionButton writeBtn;
//    private OnFragmentInteractionListener mListener;

    public FragmentEvaluateBoard() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    } // end of onCreate

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View thisFragmentView = inflater.inflate(R.layout.fragment_evaluate_board, container, false);
        writeBtn = (FloatingActionButton) thisFragmentView.findViewById(R.id.fab_main);

        posts = new ArrayList<>();
        for(int i = 0; i < 20; i++){
            posts.add(R.drawable.sample);
        }

        postModel = new EvaluatePostModel();
        postModel.setPosts(new EvaluatePost());
        postModel.getPosts(0);


        // 커스텀 아답타 생성
        GridviewAdapter adapter = new GridviewAdapter (
                getContext(),
                R.layout.evaluate_board_griditem,       // GridView 항목의 레이아웃 evaluate_board_griditem.xml
                posts);    // 데이터

        GridView gv = (GridView)thisFragmentView.findViewById(R.id.gridView1);
        gv.setAdapter(adapter);  // 커스텀 아답타를 GridView 에 적용

        writeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), EvaluatePostWrite.class);
                startActivity(intent);
            }
        });

        // GridView 아이템을 클릭하면 상단 텍스트뷰에 position 출력
        // JAVA8 에 등장한 lambda expression 으로 구현했습니다. 코드가 많이 간결해지네요
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
//                posts[position]
                 //postModel.getPosts(position);
                Intent intent = new Intent(getActivity(), EvaluateActivity.class);
                intent.putExtra("userNick", posts.get(position));
                startActivity(intent);
            }
        });
        // Inflate the layout for this fragment
        return thisFragmentView;
    }

//    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }
//o
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
