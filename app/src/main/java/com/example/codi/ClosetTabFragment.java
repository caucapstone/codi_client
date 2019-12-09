package com.example.codi;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;


/*
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ClosetTabFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ClosetTabFragment#newInstance} factory method to
 * create an instance of this fragment.
 */

public class ClosetTabFragment extends Fragment {

    ImageButton imageButton;
    Button top;
    Button pants;
    ClosetModel Closet;
    ArrayList<Integer> posts;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_closet_tab, container, false);

        imageButton = (ImageButton) view.findViewById(R.id.imageButton);
        top = (Button)view.findViewById(R.id.closet_top_btn);
        pants = (Button) view.findViewById(R.id.closet_pants_btn);

        Closet = new ClosetModel();
        Closet.setTop(new Top());
        Closet.setPants(new Pants());
        Closet.getTop(0);
        Closet.getPants(0);

        posts = new ArrayList<>();
        for(int i = 0; i < 20; i++){
            posts.add(R.drawable.casual5);
        }

        GridviewAdapter adapter = new GridviewAdapter (
                getContext(),
                R.layout.closet_griditem,       // GridView 항목의 레이아웃 evaluate_board_griditem.xml
                posts);    // 데이터

        GridView gv = (GridView)view.findViewById(R.id.gridView1);
        gv.setAdapter(adapter);  // 커스텀 아답타를 GridView 에 적용

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ClosetAddActivity.class);
                startActivity(intent);
            }
        });

        top.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                posts = new ArrayList<>();
                for(int i = 0; i < 20; i++){
                    posts.add(R.drawable.casual5);
                }

                GridviewAdapter adapter = new GridviewAdapter (
                        getContext(),
                        R.layout.closet_griditem,       // GridView 항목의 레이아웃 evaluate_board_griditem.xml
                        posts);    // 데이터

                GridView gv = (GridView)getView().findViewById(R.id.gridView1);
                gv.setAdapter(adapter);
            }
        });

        pants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                posts = new ArrayList<>();
                for(int i = 0; i < 20; i++){
                    posts.add(R.drawable.pants14);
                }

                GridviewAdapter adapter = new GridviewAdapter (
                        getContext(),
                        R.layout.closet_griditem,       // GridView 항목의 레이아웃 evaluate_board_griditem.xml
                        posts);    // 데이터

                GridView gv = (GridView)getView().findViewById(R.id.gridView1);
                gv.setAdapter(adapter);

            }
        });





        return view;
    }
}
