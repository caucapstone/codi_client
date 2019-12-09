package com.example.codi;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class TabPagerAdapter extends FragmentStatePagerAdapter {

    // Count number of tabs
    private int tabCount;

    public TabPagerAdapter(FragmentManager fm, int tabCount){
        super(fm);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position){

        //Returning the current tabs
        switch(position){
            case 0:
                FragmentEvaluateBoard fragmentEvaluateBoard = new FragmentEvaluateBoard();
                return fragmentEvaluateBoard;
//                EvaluateTabFragment evaluateTabFragment = new EvaluateTabFragment();
//                return evaluateTabFragment;
            case 1:
                FragmentRecommendBoard fragmentRecommendBoard = new FragmentRecommendBoard();
                return fragmentRecommendBoard;
//                RecommendTabFragment recommendTabFragment = new RecommendTabFragment();
//                return recommendTabFragment;
            case 2:
                ClosetTabFragment closetTabFragment = new ClosetTabFragment();
                return closetTabFragment;
            case 3:
                InfoTabFragment infoTabFragment = new InfoTabFragment();
                return infoTabFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount(){
        return tabCount;
    }

}
