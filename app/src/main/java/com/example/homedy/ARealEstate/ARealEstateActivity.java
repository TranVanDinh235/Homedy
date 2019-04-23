package com.example.homedy.ARealEstate;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.homedy.R;

public class ARealEstateActivity extends AppCompatActivity {

    private ImagePagerAdapter imagePagerAdapter;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_areal_estate);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




        imagePagerAdapter = new ImagePagerAdapter(getSupportFragmentManager());

        viewPager = (ViewPager) findViewById(R.id.vp_image);
        viewPager.setAdapter(imagePagerAdapter);
    }

}
