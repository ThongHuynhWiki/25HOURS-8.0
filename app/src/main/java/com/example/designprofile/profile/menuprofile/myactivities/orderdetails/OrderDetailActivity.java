package com.example.designprofile.profile.menuprofile.myactivities.orderdetails;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.designprofile.R;
import com.example.designprofile.profile.menuprofile.myactivities.ItemOrder;
import com.example.designprofile.profile.menuprofile.myactivities.ItemProduct;

import java.io.Serializable;
import java.util.List;

public class OrderDetailActivity extends AppCompatActivity {

    private String orderID;
    private TextView txtOrderID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);

        initWidgets();

        setAllData();
    }

    private void setAllData() {

        getDataIntent();

        txtOrderID.setText("Order #" + orderID);
    }

    private void getDataIntent() {

        Intent  intent = getIntent();
        orderID = intent.getStringExtra("data");
    }

    private void initWidgets() {

        txtOrderID = findViewById(R.id.txtOrderID);

    }
}