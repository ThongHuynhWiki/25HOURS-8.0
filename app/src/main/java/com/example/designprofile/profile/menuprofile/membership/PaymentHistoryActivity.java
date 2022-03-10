package com.example.designprofile.profile.menuprofile.membership;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.designprofile.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

import java.util.ArrayList;

public class PaymentHistoryActivity extends AppCompatActivity implements View.OnClickListener{

    private RecyclerView rcvPaymentHistory;

    private ArrayList<ItemPaymentHistory> list;
    private PaymentHistoryAdapter adapterMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_history);

        initWidgets();

        setAllData();

        eventWidgets();

    }

    private void eventWidgets() {
    }

    private void setAllData() {

        setDataMenuProfile();

    }

    private void setDataMenuProfile() {

        list = new ArrayList<>();

        list = getDataMenu();

        adapterMenu = new PaymentHistoryAdapter(PaymentHistoryActivity.this);

        adapterMenu.setData(list);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(PaymentHistoryActivity.this,LinearLayoutManager.VERTICAL,false);
        rcvPaymentHistory.setLayoutManager(linearLayoutManager);

        rcvPaymentHistory.setAdapter(adapterMenu);
    }

    private ArrayList<ItemPaymentHistory> getDataMenu() {
        ArrayList<ItemPaymentHistory> data = new ArrayList<>();

        data.add(new ItemPaymentHistory(1500, "11 Jan 2021"));
        data.add(new ItemPaymentHistory(1500, "11 Jan 2021"));
        data.add(new ItemPaymentHistory(1500, "11 Jan 2021"));
        data.add(new ItemPaymentHistory(1500, "11 Jan 2021"));
        data.add(new ItemPaymentHistory(1500, "11 Jan 2021"));
        data.add(new ItemPaymentHistory(1500, "11 Jan 2021"));
        data.add(new ItemPaymentHistory(1500, "11 Jan 2021"));
        data.add(new ItemPaymentHistory(1500, "11 Jan 2021"));
        data.add(new ItemPaymentHistory(1500, "11 Jan 2021"));
        data.add(new ItemPaymentHistory(1500, "11 Jan 2021"));
        data.add(new ItemPaymentHistory(1500, "11 Jan 2021"));
        data.add(new ItemPaymentHistory(1500, "11 Jan 2021"));
        data.add(new ItemPaymentHistory(1500, "11 Jan 2021"));
        data.add(new ItemPaymentHistory(1500, "11 Jan 2021"));
        data.add(new ItemPaymentHistory(1500, "11 Jan 2021"));
        return data;
    }

    private void initWidgets() {

        rcvPaymentHistory = findViewById(R.id.rcvListPaymentHistory);
    }

    @Override
    public void onClick(View view) {

    }

}