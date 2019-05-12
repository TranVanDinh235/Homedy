package com.example.homedy.Post;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.homedy.R;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;


import butterknife.ButterKnife;
import butterknife.InjectView;


public class NewPostActivity extends AppCompatActivity implements DialogPost3Fragment.DialogPost3Listener {

    private static final int REQUEST_ID_IMAGE_CAPTURE = 100;
    private static final int GALLERY_REQUEST_CODE = 98;
    private static final int REQUEST_ID_AVATAR_IMAGE_CAPTURE = 101;
    private static final int AVATAR_GALLERY_REQUEST_CODE = 102;
    private static final String TAG = "tag";
    private Post post = new Post();

    int numberImage = 0;

    @InjectView(R.id.radioGroup_newpost_type)
    RadioGroup _posttypeRadioGroup;
    @InjectView(R.id.radioButton_newpost_forRent)
    RadioButton _postRentRadioButton;
    @InjectView(R.id.radioButton_newpost_oGhep)
    RadioButton _postOghepRadioButton;
    @InjectView(R.id.btn_newpost_addImage)
    Button _addImageButton;
    @InjectView(R.id.edt_newpost_title)
    EditText _titleEditText;
    @InjectView(R.id.btn_newpost_typeRoom)
    Button _typeRoomButton;
    @InjectView(R.id.edt_newpost_rent)
    EditText _rentEditText;
    @InjectView(R.id.edt_newpost_area)
    EditText _areaEditText;
    @InjectView(R.id.btn_newpost_address)
    Button _addressButton;
    @InjectView(R.id.edt_newpost_phone)
    EditText _phoneEditText;
    @InjectView(R.id.edt_newpost_description)
    EditText _descriptionEditText;
    @InjectView(R.id.imv_newpost_avatar)
    ImageView _avatarImageView;
    @InjectView(R.id.linlayout_newpost_image)
    LinearLayout _imageLinearLayout;


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
                DialogPost2Fragment dialogPost2Fragment = DialogPost2Fragment.newInstance(2);
                dialogPost2Fragment.show(getSupportFragmentManager(), "");
            }
        });

        _addImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogPost2Fragment dialogPost2Fragment = DialogPost2Fragment.newInstance(1);
                dialogPost2Fragment.show(getSupportFragmentManager(), "");

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
                _addressButton.setText("address");
            }
        });


    }

    /*
    hàm chuyển bitmap thành String
     */
    public String getStringFromBitmap(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        String encodedImage = Base64.encodeToString(byteArray, Base64.DEFAULT);
        return encodedImage;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.newpost_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.toolbar_newpost_send:
                if (checkPost()) {
                } else {
                    Log.d(TAG, "onOptionsItemSelected: false");
                }
                break;
            case android.R.id.home:
                finish();
                break;
            default:
                super.onOptionsItemSelected(item);
                break;
        }
        return true;
    }


    // ham gui du lieu bai dang moi duoi dang json
    private void newpost(Post post) throws JSONException {

    }

    // ham kiem tra xem mot tin da duoc dien day du thong tin hay chua

    public boolean checkPost() {

        if (_posttypeRadioGroup.getCheckedRadioButtonId() == -1) {
            Toast.makeText(NewPostActivity.this, "Bạn chưa chọn loại tin!!", Toast.LENGTH_SHORT).show();
            return false;
        }

//        if(_avatarImageView.getDrawable() == null){
//            Toast.makeText(NewPostActivity.this, "Bạn chưa chọn ảnh đại diện cho tin", Toast.LENGTH_SHORT).show();
//            return false;
//        }

        if (_titleEditText.getText().toString().matches("")) {
            Toast.makeText(NewPostActivity.this, "Bạn chưa có tiêu đề của tin", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (_typeRoomButton.getText().toString().matches("")) {
            Toast.makeText(NewPostActivity.this, "Bạn chưa chọn kiểu phòng", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (_rentEditText.getText().toString().matches("")) {
            Toast.makeText(NewPostActivity.this, "Bạn chưa nhập giá cho thuê ", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (_areaEditText.getText().toString().matches("")) {
            Toast.makeText(NewPostActivity.this, "Bạn chưa nhập diện tích cho thuê", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (_addressButton.getText().toString().matches("")) {
            Toast.makeText(NewPostActivity.this, "Bạn chưa nhập địa chỉ", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (_phoneEditText.getText().toString().matches("")) {
            Toast.makeText(NewPostActivity.this, "Bạn chưa nhập số điện thoại", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (_descriptionEditText.getText().toString().matches("")) {
            Toast.makeText(NewPostActivity.this, "Bạn chưa nhập mô tả", Toast.LENGTH_SHORT).show();
            return false;
        }
//        if(_imageLinearLayout.getChildCount() < 3){
//            Toast.makeText(NewPostActivity.this, "Bạn cần thêm ảnh cho tin đăng", Toast.LENGTH_SHORT).show();
//            return false;
//        }
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        Log.d(TAG, "onSupportNavigateUp: back activity");
        return true;
    }

    // khi activity chup hinh hoan thanh thi ham nay se duoc goi
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {

            switch (requestCode) {
                case REQUEST_ID_IMAGE_CAPTURE:
                    Bitmap bp = (Bitmap) data.getExtras().get("data");
                    Log.d(TAG, "onActivityResult: camera");
                    ImageView image_capture = new ImageView(this);
                    image_capture.setLayoutParams(new android.view.ViewGroup.LayoutParams(300, 300));
                    image_capture.setMaxHeight(100);
                    image_capture.setMaxWidth(100);
                    image_capture.setImageBitmap(bp);
                    _imageLinearLayout.addView(image_capture);
                    if (numberImage++ == 3)
                        _addImageButton.setVisibility(View.INVISIBLE);

                    break;

                case GALLERY_REQUEST_CODE:
                    if (data.getData() != null) {
                        //If uploaded with Android Gallery (max 1 image)
                        Uri selectedImage = data.getData();
                        InputStream imageStream;
                        try {
                            imageStream = getContentResolver().openInputStream(selectedImage);
                            Bitmap bitmap = BitmapFactory.decodeStream(imageStream);
                            ImageView image = new ImageView(this);
                            image.setLayoutParams(new android.view.ViewGroup.LayoutParams(300, 300));
                            image.setMaxHeight(100);
                            image.setMaxWidth(100);
                            image.setImageBitmap(bitmap);
                            _imageLinearLayout.addView(image);
                            numberImage++;
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    } else {
                        //If uploaded with the new Android Photos gallery
                        try {
                            Log.d(TAG, "onActivityResult: pig image");
                            ClipData clipData = data.getClipData();
                            int numItem = 3;
                            if (numItem > (clipData.getItemCount() + numberImage))
                                numItem = clipData.getItemCount();
                            else numItem = 3 - numberImage;
                            for (int i = 0; i < numItem; i++) {
                                ClipData.Item item = clipData.getItemAt(i);
                                Uri imageUri = item.getUri();
                                InputStream imageStream = getContentResolver().openInputStream(imageUri);
                                Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                                ImageView image = new ImageView(this);
                                image.setLayoutParams(new android.view.ViewGroup.LayoutParams(300, 300));
                                image.setMaxHeight(100);
                                image.setMaxWidth(100);
                                image.setImageBitmap(selectedImage);
                                _imageLinearLayout.addView(image);
                            }
                            numberImage += numItem;
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                            Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG).show();
                        }
                    }
                    if (numberImage == 3) _addImageButton.setVisibility(View.INVISIBLE);
                    break;

                case REQUEST_ID_AVATAR_IMAGE_CAPTURE:
                    Bitmap bpAvatar = (Bitmap) data.getExtras().get("data");
                    _avatarImageView.setImageBitmap(bpAvatar);
                    break;

                case AVATAR_GALLERY_REQUEST_CODE:
                    if (data.getData() != null) {
                        Uri selectAvatarImage = data.getData();
                        InputStream imageStream;
                        try {
                            imageStream = getContentResolver().openInputStream(selectAvatarImage);
                            Bitmap bitmap = BitmapFactory.decodeStream(imageStream);
                            _avatarImageView.setImageBitmap(bitmap);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    } else {
                        ClipData clipData = data.getClipData();
                        ClipData.Item item = clipData.getItemAt(0);
                        Uri selectAvatarGalley = item.getUri();
                        InputStream mutilImageSteam;
                        try {
                            mutilImageSteam = getContentResolver().openInputStream(selectAvatarGalley);
                            Bitmap bitmap = BitmapFactory.decodeStream(mutilImageSteam);
                            _avatarImageView.setImageBitmap(bitmap);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                    break;

            }
        } else if (resultCode == RESULT_CANCELED) {
            Toast.makeText(this, "Action canced!!", Toast.LENGTH_LONG).show();
        } else Toast.makeText(this, "Action Failed", Toast.LENGTH_LONG).show();

    }

    public Uri getImageUri(Context inContext, Bitmap inImage) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        inImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        String path = MediaStore.Images.Media.insertImage(inContext.getContentResolver(), inImage, "Title", null);
        return Uri.parse(path);
    }

    public String getRealPathFromURI(Uri uri) {
        String path = "";
        if (getContentResolver() != null) {
            Cursor cursor = getContentResolver().query(uri, null, null, null, null);
            if (cursor != null) {
                cursor.moveToFirst();
                int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
                path = cursor.getString(idx);
                cursor.close();
            }
        }
        return path;
    }


    @Override
    public void setDataFromFragment(String data) {
        _typeRoomButton.setText(data);
    }
}

