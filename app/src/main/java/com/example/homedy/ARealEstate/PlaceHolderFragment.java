package com.example.homedy.ARealEstate;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.homedy.R;

public class PlaceHolderFragment extends Fragment {

    private static final String KEY_IMAGE = "key_image";

    public PlaceHolderFragment(){}

    public static PlaceHolderFragment newInstance(int image){
        PlaceHolderFragment fragment = new PlaceHolderFragment();
        Bundle args = new Bundle();
        args.putInt(KEY_IMAGE, image);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_a_realstate,container,false);
        ImageView imageView = (ImageView) rootView.findViewById(R.id.img_a_realestate);
        switch (getArguments().getInt(KEY_IMAGE)) {
            case 1:
                imageView.setImageResource(R.drawable.image1);
                break;
            case 2:
                imageView.setImageResource(R.drawable.image2);
                break;
            case 3:
                imageView.setImageResource(R.drawable.image3);
                break;
            case 4:
                imageView.setImageResource(R.drawable.image4);
                break;
            case 5:
                imageView.setImageResource(R.drawable.image5);
                break;
                default:
                    imageView.setImageResource(R.drawable.image1);
                    break;
        }
        return rootView;
    }
}

