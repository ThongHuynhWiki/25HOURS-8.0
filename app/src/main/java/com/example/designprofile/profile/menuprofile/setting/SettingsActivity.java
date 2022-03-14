package com.example.designprofile.profile.menuprofile.setting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.designprofile.R;
import com.example.designprofile.profile.menuprofile.account.changepassword.ChangePasswordActivity;
import com.example.designprofile.profile.menuprofile.setting.selectsetting.SelectSettingActivity;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener {

    private RelativeLayout relPushNotifications;
    private RelativeLayout relBiometricSettings;
    private RelativeLayout relChangePassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        initWidgets();

        eventWidgets();
    }

    private void eventWidgets() {
        relPushNotifications.setOnClickListener(this);
        relBiometricSettings.setOnClickListener(this);
        relChangePassword.setOnClickListener(this);
    }

    private void initWidgets() {

        relPushNotifications = findViewById(R.id.relPushNotifications);
        relBiometricSettings = findViewById(R.id.relBiometricSettings);
        relChangePassword = findViewById(R.id.relChangePassword);

    }

    @Override
    public void onClick(View view) {

        Intent intent = null;

        switch (view.getId()){

            case R.id.relPushNotifications:

                intent = new Intent(SettingsActivity.this, SelectSettingActivity.class);
                intent.putExtra("check", true);
                break;

            case R.id.relBiometricSettings:

                intent = new Intent(SettingsActivity.this, SelectSettingActivity.class);
                intent.putExtra("check", false);
                break;

            case R.id.relChangePassword:

                intent = new Intent(SettingsActivity.this, ChangePasswordActivity.class);

                break;

        }

        if (intent != null){

            startActivity(intent);

        }
    }
}