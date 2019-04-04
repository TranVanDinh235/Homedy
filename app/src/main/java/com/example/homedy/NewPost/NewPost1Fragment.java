package com.example.homedy.NewPost;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.homedy.R;

import butterknife.ButterKnife;
import butterknife.InjectView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link NewPost1Fragment} interface
 * to handle interaction events.
 * Use the {@link NewPost1Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NewPost1Fragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String KEY_TAB = "key_tab";

    private static final int DIALOG_FRAGMENT = 1;

    @InjectView(R.id.btn_post_city) Button _cityPostButton;
    @InjectView(R.id.btn_post_district) Button _districtPostButton;
    @InjectView(R.id.btn_post_commune) Button _communePostButton;
    @InjectView(R.id.btn_post_street) Button _streetPostButton;
    @InjectView(R.id.edt_post_address) EditText addressPostEditText;
    @InjectView(R.id.btn_post_delete) Button _deletePostButton;
    @InjectView(R.id.btn_post_next) Button _nextPostButton;

    // TODO: Rename and change types of parameters
    private int keyTab;
    private String mParam2;

    private OnNewPostFragmentListener mListener;

    public NewPost1Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment NewPost1Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NewPost1Fragment newInstance(int tab) {
        NewPost1Fragment fragment = new NewPost1Fragment();
        Bundle args = new Bundle();
        args.putInt(KEY_TAB, tab);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            keyTab = getArguments().getInt(KEY_TAB);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_new_post1, container, false);
        ButterKnife.inject(this, view);
        _cityPostButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogPostFragment dialogPostFragment = new DialogPostFragment();
                dialogPostFragment.setTargetFragment(NewPost1Fragment.this, DIALOG_FRAGMENT);
                dialogPostFragment.show(getFragmentManager().beginTransaction(),"city picker");
            }
        });


        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(String uri) {
        if (mListener != null) {
            mListener.onItemPress(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnNewPostFragmentListener) {
            mListener = (OnNewPostFragmentListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnNewPostFragmentListener {
        // TODO: Update argument type and name
        void onItemPress(String content);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case DIALOG_FRAGMENT:
                if (resultCode == Activity.RESULT_OK) {
                    // here the part where I get my selected date from the saved variable in the intent and the displaying it.
                    Bundle bundle = data.getExtras();
                    String result = bundle.getString("result", "error");
                    _cityPostButton.setText(result);
                }
                break;
        }
    }
}
