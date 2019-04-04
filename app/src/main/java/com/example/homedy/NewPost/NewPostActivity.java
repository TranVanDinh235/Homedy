package com.example.homedy.NewPost;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.homedy.R;

public class NewPostActivity extends AppCompatActivity implements NewPost1Fragment.OnNewPostFragmentListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newpost);

        NewPost1Fragment newPost1Fragment = NewPost1Fragment.newInstance(1);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.content_fragment_newpost, newPost1Fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onItemPress(String content) {

    }
}
