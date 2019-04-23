package com.example.homedy;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.homedy.Account.AccountFragment;
import com.example.homedy.Account.LoginFragment;
import com.example.homedy.Home.HomeFragment;
import com.example.homedy.Post.PostFragment;
import com.example.homedy.Search.SearchFragment;

public class MainActivity extends AppCompatActivity implements HomeFragment.OnHomeFragmentListener, LoginFragment.OnLoginFragmentListener, AccountFragment.OnAccountFragmentListener, PostFragment.OnPostFragmentListener, SearchFragment.OnFragmentInteractionListener{
    private HomeFragment homeFragment = HomeFragment.newInstance(1);
    private LoginFragment loginFragment = LoginFragment.newInstance(false);
    private PostFragment postFragment = PostFragment.newInstance(3);
    private SearchFragment searchFragment = SearchFragment.newInstance(null, null);


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId()){
                case R.id.navigation_home:
                    loadFragment(R.id.frame_layout, homeFragment);
                    return true;
                case R.id.navigation_account:
                    loadFragment(R.id.frame_layout, loginFragment);
                    return true;
                case R.id.navigation_post:
                    loadFragment(R.id.frame_layout, postFragment);
                    return true;
                case R.id.navigation_search:
                    loadFragment(R.id.frame_layout, searchFragment);
                    return true;
            }

            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        loadFragment(R.id.frame_layout, homeFragment);

    }

    public void loadFragment(int i, Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(i, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onItemPressed(String content) {

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    @Override
    public void onLoginFragmentListenre(Uri uri) {

    }

    @Override
    public void onAccountFragmentListener(Uri uri) {

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
