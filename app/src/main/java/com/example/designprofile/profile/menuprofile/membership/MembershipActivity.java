package com.example.designprofile.profile.menuprofile.membership;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.designprofile.R;

public class MembershipActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView txtCancel;
    private TextView btnPaymentHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_membership);

        initWidgets();

        setAllData();

        eventWidgets();
    }

    private void eventWidgets() {

        txtCancel.setOnClickListener(this);
        btnPaymentHistory.setOnClickListener(this);
    }

    private void setAllData() {
    }

    private void initWidgets() {

        txtCancel = findViewById(R.id.txtCancel);
        btnPaymentHistory = findViewById(R.id.btnPaymentHistory);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.txtCancel:

                onBackPressed();

                break;

            case R.id.btnPaymentHistory:

                startActivity(new Intent(MembershipActivity.this, PaymentHistoryActivity.class));
                break;
        }
    }
}