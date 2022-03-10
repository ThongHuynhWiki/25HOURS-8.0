package com.example.designprofile.profile.menuprofile.membershipcard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.designprofile.R;
import com.example.designprofile.profile.root.RootApplication;

public class MembershipCardActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imgBack;
    private ImageView imgBackgroundInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_membership_card);

        initWidgets();

        setAllData();

        eventWidgets();
    }

    private void eventWidgets() {

        imgBack.setOnClickListener(this);

    }

    private void setAllData() {

        setBackgrountInfo();

    }

    private void setBackgrountInfo() {

        RootApplication.loadImageGif(MembershipCardActivity.this, R.drawable.background_card_info, imgBackgroundInfo);

    }



    private void initWidgets() {

        imgBack = findViewById(R.id.imgBack);
        imgBackgroundInfo = findViewById(R.id.imgBackgroundInfo);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.imgBack:

                onBackPressed();

                break;
        }
    }

}