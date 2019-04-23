package com.example.homedy.Post;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.homedy.Home.HomeItem;
import com.example.homedy.R;

import java.net.Socket;
import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

import static android.content.ContentValues.TAG;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PostFragment} interface
 * to handle interaction events.
 * Use the {@link PostFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PostFragment extends Fragment {
    private static final int REQUEST_POST = 0;
    private static boolean checkDelete = false;

    private ArrayList<HomeItem> homeItems1 = HomeItem.getExameHome();

    Socket mSocket;



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String KEY_TAG = "key_tag";

    @InjectView(R.id.fab) FloatingActionButton _newPostButton;

    // TODO: Rename and change types of parameters
    private int keyTag;

    private OnPostFragmentListener mListener;

    public PostFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment PostFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PostFragment newInstance(int tag) {
        PostFragment fragment = new PostFragment();
        Bundle args = new Bundle();
        args.putInt(KEY_TAG, tag);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            keyTag = getArguments().getInt(KEY_TAG);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_post, container, false);
        ButterKnife.inject(this,view);

        RecyclerView recyclerView = view.findViewById(R.id.rv_post);
        RecycleViewPostAdapter recycleViewPostAdapter = new RecycleViewPostAdapter(homeItems1, new ClickListener() {
            @Override
            public void onPostitionClick(int position) {
                Toast.makeText(view.getContext(), "row press", Toast.LENGTH_LONG).show();
            }
        }, new RecycleViewPostAdapter.ItemDeleteClickListener() {
            @Override
            public boolean onItemDeleteClick() {
                Log.d(TAG, "onItemDeleteClick: ");
                DialogFragment dialogFragment = new MyDialogFragment();
                dialogFragment.show(getActivity().getSupportFragmentManager(),"");
                if(checkDelete){
                    checkDelete = false;
                    return true;
                }
                return false;

            }
        });
        recyclerView.setAdapter(recycleViewPostAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        _newPostButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),NewPostActivity.class );
                getActivity().startActivityForResult(intent, REQUEST_POST);
            }
        });

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(String uri) {
        if (mListener != null) {
            mListener.onItemPressed(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnPostFragmentListener) {
            mListener = (OnPostFragmentListener) context;
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

    public interface OnPostFragmentListener {
        // TODO: Update argument type and name
        void onItemPressed(String content);
    }

    @SuppressLint("ValidFragment")
    public static class MyDialogFragment extends android.support.v4.app.DialogFragment{
        @NonNull
        @Override
        public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle("Bạn có chắc muốn xoá bài đăng này hay không?")
                    .setPositiveButton("Xoá", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            checkDelete = true;
                            dismiss();
                        }
                    })
                    .setNegativeButton("Không", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dismiss();
                        }
                    });
            return builder.create();
        }
    }


}
