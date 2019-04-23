package com.example.homedy.Post;

import android.Manifest;
import android.content.ClipData;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.homedy.Bedsit;
import com.example.homedy.R;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import butterknife.ButterKnife;
import butterknife.InjectView;
import static android.support.constraint.Constraints.TAG;


public class NewPostActivity extends AppCompatActivity implements DialogPost3Fragment.DialogPost3Listener{

    private static final int REQUEST_ID_IMAGE_CAPTURE = 100;
    private static final int REQUEST_ID_READ_WRITE_PERMISSION = 99;
    private static final int GALLERY_REQUEST_CODE = 98;

    private final static int MAX_IMAGE = 3;
    private int numberImage = 0;

    @InjectView(R.id.btn_newpost_addImage) Button _addImageButton;
    @InjectView(R.id.edt_newpost_title) EditText _titleEditText;
    @InjectView(R.id.btn_newpost_typeRoom) Button _typeRoomButton;
    @InjectView(R.id.edt_newpost_rent) EditText _rentEditText;
    @InjectView(R.id.edt_newpost_area) EditText _areaEditText;
    @InjectView(R.id.btn_newpost_address) Button _addressButton;
    @InjectView(R.id.edt_newpost_phone) EditText _phoneEditText;
    @InjectView(R.id.edt_newpost_description) EditText _descriptionEditText;
    @InjectView(R.id.imv_newpost_avatar) ImageView _avatarImageView;
    @InjectView(R.id.linlayout_newpost_image) LinearLayout _imageLinearLayout;

    private Bedsit bedsit = new Bedsit();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_post);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Đăng bài");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        ButterKnife.inject(this);

        _avatarImageView.setClickable(true);
        _avatarImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        _addImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogPost2Fragment dialogPost2Fragment = new DialogPost2Fragment();
                dialogPost2Fragment.show(getSupportFragmentManager(),"");

            }
        });

        _typeRoomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogPost3Fragment dialogPost3Fragment = new DialogPost3Fragment();
                dialogPost3Fragment.show(getSupportFragmentManager(), "");
            }
        });


        _addressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.newpost_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.toolbar_newpost_send:
                finish();
                break;
            case android.R.id.home:
                finish();
             default:
                super.onOptionsItemSelected(item);
                break;
        }
        return true;
    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        Log.d(TAG, "onSupportNavigateUp: back activity");
        return true;
    }


    // yeu cau quyen truy cap doc va ghi du lieu vao thiet bi
    public void askPermission(){
        if(Build.VERSION.SDK_INT > 23){
            int readPermission = ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);
            int writePermission = ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);

            if(writePermission != PackageManager.PERMISSION_GRANTED || readPermission != PackageManager.PERMISSION_GRANTED)
            {
                this.requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_ID_READ_WRITE_PERMISSION);

            }
            else
                this.captureImage();
        }
    }


    private void captureImage(){
        // Tao mot intent khong tuong minh de yeu cau he thong mo camera chuan bi chup hinh
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        // start activity chup hinh va cho doi ket qua tra ve
        this.startActivityForResult(intent, REQUEST_ID_IMAGE_CAPTURE);
    }


    // khi yeu cau nguoi dung duoc tra ve (chap nhan hoac khong chap nhan)
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode){
            case REQUEST_ID_READ_WRITE_PERMISSION:
                if(grantResults.length > 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(this, "Permisthion granted", Toast.LENGTH_LONG).show();
                    this.captureImage();
                }
                else {
                    Toast.makeText(this, "Permission denied", Toast.LENGTH_LONG).show();
                }
                break;
        }
    }

    private void pickFromGallery(){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
        intent.setAction(Intent.ACTION_GET_CONTENT);
        this.startActivityForResult(Intent.createChooser(intent,"Select Picture"), GALLERY_REQUEST_CODE);
    }


    // khi activity chup hinh hoan thanh thi ham nay se duoc goi
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK){

            switch (requestCode) {
                case REQUEST_ID_IMAGE_CAPTURE:
                    Bitmap bp = (Bitmap) data.getExtras().get("data");
                    if(numberImage < MAX_IMAGE){
                        Log.d(TAG, "onActivityResult: camera");
                        ImageView image = new ImageView(this);
                        image.setLayoutParams(new android.view.ViewGroup.LayoutParams(300,300));
                        image.setMaxHeight(100);
                        image.setMaxWidth(100);
                        image.setImageBitmap(bp);
                        _imageLinearLayout.addView(image);
                        numberImage++;
                    }
                    break;

                case GALLERY_REQUEST_CODE:
                    if(data.getData() != null){
                        //If uploaded with Android Gallery (max 1 image)
                        Uri selectedImage = data.getData();
                        InputStream imageStream;
                        try {
                            imageStream = getContentResolver().openInputStream(selectedImage);
                            Bitmap bitmap = BitmapFactory.decodeStream(imageStream);
                            ImageView image = new ImageView(this);
                            image.setLayoutParams(new android.view.ViewGroup.LayoutParams(300,300));
                            image.setMaxHeight(100);
                            image.setMaxWidth(100);
                            image.setImageBitmap(bitmap);
                            _imageLinearLayout.addView(image);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    } else {
                        //If uploaded with the new Android Photos gallery
                        try {
                            Log.d(TAG, "onActivityResult: pig image");
                            ClipData clipData = data.getClipData();
                            for (int i = 0; i < clipData.getItemCount(); i ++) {
                                ClipData.Item item = clipData.getItemAt(i);
                                Uri imageUri = item.getUri();
                                InputStream imageStream = getContentResolver().openInputStream(imageUri);
                                Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                                ImageView image = new ImageView(this);
                                image.setLayoutParams(new android.view.ViewGroup.LayoutParams(300,300));
                                image.setMaxHeight(100);
                                image.setMaxWidth(100);
                                image.setImageBitmap(selectedImage);
                                _imageLinearLayout.addView(image);
                                numberImage ++;
                            }
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                            Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG).show();
                        }
                    }
            }
        }
        else if(resultCode == RESULT_CANCELED){
            Toast.makeText(this, "Action canced!!", Toast.LENGTH_LONG).show();
        }
        else Toast.makeText(this, "Action Failed", Toast.LENGTH_LONG).show();

    }


    // ham dung de giu anh bipmap khong bi xoay
    public static Bitmap modifyOrientation(Bitmap bitmap, String image_absolute_path) throws IOException {
        ExifInterface exifInterface = new ExifInterface(image_absolute_path);

        int orientation = exifInterface.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);
        switch (orientation) {
            case ExifInterface.ORIENTATION_ROTATE_90:
                return rotate(bitmap, 90);
            case ExifInterface.ORIENTATION_ROTATE_180:
                return rotate(bitmap, 180);
            case ExifInterface.ORIENTATION_ROTATE_270:
                return rotate(bitmap, 270);
            case ExifInterface.ORIENTATION_FLIP_HORIZONTAL:
                return flip(bitmap, true, false);
            case ExifInterface.ORIENTATION_FLIP_VERTICAL:
                return flip(bitmap, false, true);

            default:
                return bitmap;
        }
    }

    public static Bitmap rotate(Bitmap bitmap, float degrees) {
        Matrix matrix = new Matrix();
        matrix.postRotate(degrees);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public static Bitmap flip(Bitmap bitmap, boolean horizontal, boolean vertical){
        Matrix matrix = new Matrix();
        matrix.preScale(horizontal ? -1 : 1, vertical ? -1 : 1);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    @Override
    public void setDataFromFragment(String data) {
        _typeRoomButton.setText(data);
    }
}
