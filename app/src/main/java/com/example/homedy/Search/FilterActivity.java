package com.example.homedy.Search;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.homedy.Address;
import com.example.homedy.Post.DialogPostFragment;
import com.example.homedy.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class FilterActivity extends AppCompatActivity implements DialogPostFragment.DialogPostFragmetListener {
    @InjectView(R.id.btn_search_city) Button _searchCityButton;
    @InjectView(R.id.btn_search_distric) Button _searchDistrictButton;
    @InjectView(R.id.btn_search_commune) Button _searchCommuneButton;
    @InjectView(R.id.btn_search_street) Button _searchStreetButton;
    @InjectView(R.id.btn_search_area) Button _searchAreaButton;
    @InjectView(R.id.btn_search_price) Button _searchPriceButton;
    @InjectView(R.id.btn_search_sort) Button _searchSortButton;

    String[] citys = Address.citys;
    String[] districts = Address.districts;
    String[] communes = Address.communes;
    String[] streets = Address.streets;
    String[] area = {"<10 m2", "10-15 m2", "15-20 m2", "20-30 m2", "30-50 m2", "50-100 m2", ">100 m2"};
    String[] price = {"dưới 1 triệu", "1-2 triệu", "2-3 triệu", "3-5 triệu", "5-10 triệu", ">10 triệu"};
    String[] sort = {"Mới nhất","Theo giá lớn nhất", "Theo giá nhỏ nhất", "Theo diện tích lớn nhất", "Theo diện tích nhỏ nhất"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);

        ButterKnife.inject(this);

        _searchCityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogPostFragment dialogPostFragment = DialogPostFragment.newInstance(citys,_searchCityButton.getId());
                dialogPostFragment.show(getSupportFragmentManager(), "city");
            }
        });

        _searchDistrictButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogPostFragment dialogPostFragment = DialogPostFragment.newInstance(districts, _searchDistrictButton.getId());
                dialogPostFragment.show(getSupportFragmentManager(), "district");
            }
        });

        _searchCommuneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogPostFragment dialogPostFragment = DialogPostFragment.newInstance(communes, _searchCommuneButton.getId());
                dialogPostFragment.show(getSupportFragmentManager(), "commune");
            }
        });

        _searchStreetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogPostFragment dialogPostFragment = DialogPostFragment.newInstance(streets, _searchStreetButton.getId());
                dialogPostFragment.show(getSupportFragmentManager(), "street");
            }
        });

        _searchPriceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogPostFragment dialogPostFragment = DialogPostFragment.newInstance(price, _searchPriceButton.getId());
                dialogPostFragment.show(getSupportFragmentManager(),"price");
            }
        });

        _searchAreaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogPostFragment dialogPostFragment = DialogPostFragment.newInstance(area, _searchAreaButton.getId());
                dialogPostFragment.show(getSupportFragmentManager(), "area");
            }
        });

        _searchSortButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogPostFragment dialogPostFragment = DialogPostFragment.newInstance(sort, _searchSortButton.getId());
                dialogPostFragment.show(getSupportFragmentManager(), "sort");
            }
        });
    }

    @Override
    public void setDataFromFragment(String data, int button_id) {
        Button button = (Button) findViewById(button_id);
        button.setText(data);
    }
}
