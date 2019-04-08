package com.example.homedy.NewPost;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.homedy.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class NewPost1Activity extends AppCompatActivity implements DialogPostFragment.DialogPostFragmetListener {

    @InjectView(R.id.btn_post_city) Button _cityPostButton;
    @InjectView(R.id.btn_post_district) Button _districtPostButton;
    @InjectView(R.id.btn_post_commune) Button _communePostButton;
    @InjectView(R.id.btn_post_street) Button _streetPostButton;
    @InjectView(R.id.edt_post_address) EditText addressPostEditText;
    @InjectView(R.id.btn_post_delete) Button _deletePostButton;
    @InjectView(R.id.btn_post_next) Button _nextPostButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_post1);

        ButterKnife.inject(this);

        _cityPostButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogPostFragment dialogPostFragment = new DialogPostFragment();
                dialogPostFragment.show(getSupportFragmentManager(),"city");
            }
        });

    }


    @Override
    public void setDataFromFragment(String data) {
        _cityPostButton.setText(data);
    }
}
