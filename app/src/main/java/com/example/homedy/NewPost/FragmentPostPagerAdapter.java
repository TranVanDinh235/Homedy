package com.example.homedy.NewPost;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class FragmentPostPagerAdapter extends FragmentPagerAdapter {

    public FragmentPostPagerAdapter(FragmentManager fm){super(fm);}


    @Override
    public Fragment getItem(int i) {
        switch (i){
            case 1: return NewPost1Fragment.newInstance(1);
            default: return NewPost1Fragment.newInstance(1);
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
