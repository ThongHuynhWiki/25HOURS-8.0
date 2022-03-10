package com.example.designprofile.profile.menuprofile.account;

import android.Manifest;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.designprofile.profile.menuprofile.account.changepassword.ChangePasswordActivity;
import com.example.designprofile.R;
import com.example.designprofile.profile.root.RootApplication;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class AccountActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int CAMERA_ACTION_CODE = 123;
    private static final int PERMISSION_CODE = 123;
    private static final int GALLERY_ACTION_CODE = 234;
    private ImageView imgLogoAvatar;
    private ImageView imgIconCamera;
    private RelativeLayout relAvatar;
    private Spinner spnSalutation;
    private EditText edtFirstName;
    private TextView txtEmail;
    private TextView btnUpdate;
    private TextView btnChangePassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        initWidgets();

        setAllData();

        eventWidgets();

    }

    private void eventWidgets() {

        relAvatar.setOnClickListener(this);

        btnUpdate.setOnClickListener(this);

        btnChangePassword.setOnClickListener(this);
    }

    private void setAllData() {

        settingDataWidgets();
    }

    private void settingDataWidgets() {
        RootApplication.loadImageCircle(AccountActivity.this,
                R.drawable.logo_avatar_default,
                imgLogoAvatar);
    }

    private void initWidgets() {

        imgLogoAvatar = findViewById(R.id.imgLogoAvatar);
        imgIconCamera = findViewById(R.id.imgIconCamera);
        txtEmail = findViewById(R.id.txtEmail);
        relAvatar = findViewById(R.id.relAvatar);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnChangePassword = findViewById(R.id.btnChangePassword);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.relAvatar:

                grantPermission();

                break;

            case R.id.btnUpdate:

                openDialogComfirm();

                break;

            case R.id.btnChangePassword:

                startActivity(new Intent(AccountActivity.this, ChangePasswordActivity.class));

                break;

        }
    }

    private void openDialogComfirm() {

        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_confirm_yes_no);
        dialog.show();

    }

    private void grantPermission() {
        String[] strListPermission = {Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE};

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(strListPermission[0]) == PackageManager.PERMISSION_GRANTED
                    && checkSelfPermission(strListPermission[1]) == PackageManager.PERMISSION_GRANTED){
                openSheet();
            }else {
                requestPermissions(strListPermission, PERMISSION_CODE);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        switch (requestCode){
            case PERMISSION_CODE:

                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED){

                    openSheet();

                }else{
                    Toast.makeText(AccountActivity.this, "You have not given full permissions!", Toast.LENGTH_SHORT).show();
                }

                break;
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    private void openCamera(BottomSheetDialog bottomSheetDialog) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if(checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED){
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, CAMERA_ACTION_CODE);

            }else{

                Toast.makeText(AccountActivity.this, "You have not granted Camera permission!", Toast.LENGTH_SHORT).show();

            }
        }else {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, CAMERA_ACTION_CODE);
        }

        bottomSheetDialog.dismiss();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if (resultCode == RESULT_OK && data != null){
            Bitmap bitmap = null;

            switch (requestCode){
                case CAMERA_ACTION_CODE:
                    bitmap = (Bitmap) data.getExtras().get("data");

                    RootApplication.loadImageCircle(AccountActivity.this,
                            bitmap,
                            imgLogoAvatar);
                    break;

                case GALLERY_ACTION_CODE:

                    RootApplication.loadImageCircle(AccountActivity.this,
                            data.getData(),
                            imgLogoAvatar);

                    break;
            }
        }

        super.onActivityResult(requestCode, resultCode, data);

    }

    private void openSheet() {
        View view = getLayoutInflater().inflate(R.layout.sheet_bottom_avatar_account_profile, null);
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);

        bottomSheetDialog.setContentView(view);
        bottomSheetDialog.show();

        RelativeLayout relCamera = bottomSheetDialog.findViewById(R.id.relCamera);
        RelativeLayout relSelectFromGallery = bottomSheetDialog.findViewById(R.id.relSelectFromGallery);

        relCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCamera(bottomSheetDialog);

            }
        });

        relSelectFromGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSelectFromGallery(bottomSheetDialog);
            }
        });

    }

    private void openSelectFromGallery(BottomSheetDialog bottomSheetDialog) {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if(checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED){

                startActivityForResult(Intent.createChooser(intent,
                        "Select Picture"), GALLERY_ACTION_CODE);

            }else{
                Toast.makeText(AccountActivity.this, "You have not granted Storage permission!", Toast.LENGTH_SHORT).show();
            }
        }else {
            startActivityForResult(Intent.createChooser(intent,
                    "Select Picture"), GALLERY_ACTION_CODE);
        }
        bottomSheetDialog.dismiss();
    }
}
