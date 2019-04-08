package com.example.homedy.ARealEstate;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ImagePagerAdapter extends FragmentPagerAdapter {

    public ImagePagerAdapter(FragmentManager fm){
        super(fm);
    }


    @Override
    public Fragment getItem(int i) {
        return PlaceHolderFragment.newInstance(i + 1);
    }

    @Override
    public int getCount() {
        return 5;
    }

}