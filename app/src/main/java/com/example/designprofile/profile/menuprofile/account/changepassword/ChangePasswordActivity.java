package com.example.designprofile.profile.menuprofile.account.changepassword;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.designprofile.R;

public class ChangePasswordActivity extends AppCompatActivity implements View.OnClickListener {

    TextView btnCancel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        initWidgets();


        eventWidgets();
    }

    private void eventWidgets() {

        btnCancel.setOnClickListener(this);

    }

    private void initWidgets() {

        btnCancel = findViewById(R.id.btnCancel);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.btnCancel:
                onBackPressed();
                break;

        }
    }
}