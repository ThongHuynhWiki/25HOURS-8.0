package com.example.designprofile.profile.menuprofile.reddeempoints;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.designprofile.R;

public class RedeemPointsActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView txtMax;
    private TextView btnCancel;
    private ImageView imgBack;
    private EditText edtRedeemPoints;

    private int points = 100; // data test;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redeem_points);

        initWidgets();

        setAllData();

        eventWidgets();
    }

    private void eventWidgets() {

        txtMax.setOnClickListener(this);
        btnCancel.setOnClickListener(this);
        imgBack.setOnClickListener(this);

    }

    private void setAllData() {

        settingsData();
    }

    private void settingsData() {
        

    }

    private void initWidgets() {
        edtRedeemPoints = findViewById(R.id.edtRedeemPoints);
        btnCancel = findViewById(R.id.btnCancel);
        txtMax = findViewById(R.id.txtMax);
        imgBack = findViewById(R.id.imgBack);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imgBack:
                onBackPressed();
                break;

            case R.id.btnCancel:
                onBackPressed();
                break;

            case R.id.txtMax:

                edtRedeemPoints.setText(points + "");
                break;
        }
    }
}