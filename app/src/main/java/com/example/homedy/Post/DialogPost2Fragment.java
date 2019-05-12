package com.example.homedy.Post;

import android.Manifest;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.DialogFragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.homedy.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class DialogPost2Fragment extends DialogFragment {
    private static final int REQUEST_ID_IMAGE_CAPTURE = 100;
    private static final int REQUEST_ID_READ_WRITE_PERMISSION = 99;
    private static final int GALLERY_REQUEST_CODE = 98;
    private static final int REQUEST_ID_AVATAR_IMAGE_CAPTURE = 101;
    private static final int AVATAR_GALLERY_REQUEST_CODE = 102;
    private static final String KEY_TAB = "key_tab";


    @InjectView(R.id.btn_dialog_camera) Button _cammeraDialogButton;
    @InjectView(R.id.btn_dialog_fileimage) Button _imageFileDialogButton;

    public static DialogPost2Fragment newInstance(int buttonId) {
        Bundle args = new Bundle();
        args.putInt(KEY_TAB, buttonId);
        DialogPost2Fragment fragment = new DialogPost2Fragment();
        fragment.setArguments(args);
        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        super.onCreateDialog(savedInstanceState);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.fragment_dialog_2, null);
        ButterKnife.inject(this, view);

        _cammeraDialogButton.setText("Camera");
        _cammeraDialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getArguments().getInt(KEY_TAB) == 1) {
                    captureImage(REQUEST_ID_IMAGE_CAPTURE);
                }
                if(getArguments().getInt(KEY_TAB) == 2){
                    captureImage(REQUEST_ID_AVATAR_IMAGE_CAPTURE);
                }
                dismiss();
            }
        });

        _imageFileDialogButton.setText("Thư viện");
        _imageFileDialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getArguments().getInt(KEY_TAB) == 1) {
                    pickFromGallery(GALLERY_REQUEST_CODE);
                }
                if(getArguments().getInt(KEY_TAB) == 2){
                    pickFromGallery(AVATAR_GALLERY_REQUEST_CODE);
                }
                dismiss();
            }
        });
        builder.setView(view);
        return builder.create();
    }


    private void captureImage(int requestCode) {
        askPermission();
        // Tao mot intent khong tuong minh de yeu cau he thong mo camera chuan bi chup hinh
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        // start activity chup hinh va cho doi ket qua tra ve
        getActivity().startActivityForResult(intent, requestCode);
    }

    private void pickFromGallery(int requestCode){
        askPermission();
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
        intent.setAction(Intent.ACTION_GET_CONTENT);
        getActivity().startActivityForResult(Intent.createChooser(intent,"Select Picture"), requestCode);
    }

    private void askPermission(){
        if(Build.VERSION.SDK_INT > 23){
            int readPermission = ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.READ_EXTERNAL_STORAGE);
            int writePermission = ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE);
            if(readPermission != PackageManager.PERMISSION_GRANTED || writePermission != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(getActivity(),new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_ID_READ_WRITE_PERMISSION);
            }
        }

    }
    // khi yeu cau nguoi dung duoc tra ve (chap nhan hoac khong chap nhan)
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case REQUEST_ID_READ_WRITE_PERMISSION:
                if (grantResults.length > 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this.getActivity(), "Permisthion granted", Toast.LENGTH_LONG).show();
                    this.captureImage(requestCode);
                } else {
                    Toast.makeText(this.getActivity(), "Permission denied", Toast.LENGTH_LONG).show();
                }
                break;
        }
    }
}