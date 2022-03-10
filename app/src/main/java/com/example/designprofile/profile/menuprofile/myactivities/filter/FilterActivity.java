package com.example.designprofile.profile.menuprofile.myactivities.filter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.designprofile.R;

import java.util.ArrayList;

public class FilterActivity extends AppCompatActivity implements View.OnClickListener {

    private ArrayList<ItemCategoryFilter> list;
    private CategoryFilterAdapter adapter;
    private RecyclerView rcvFilter;

    private ImageView imgBack;
    private TextView btnApply;

    private String categoryFilter = "All";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();
        setContentView(R.layout.activity_filter);

        initWidgets();

        setAllData();

        eventWidgets();
    }

    private void eventWidgets() {

        imgBack.setOnClickListener(this);

        btnApply.setOnClickListener(this);
    }

    private void setAllData() {

        ArrayList<ItemCheckbox> data = new ArrayList<>();
        list = new ArrayList<>();
        data.add(new ItemCheckbox("Latest First", true));
        data.add(new ItemCheckbox("Earliest First", false));

        list.add(new ItemCategoryFilter("Sort By", data));

        data = new ArrayList<>();
        data.add(new ItemCheckbox("Orders", false));
        data.add(new ItemCheckbox("Not delivered", false));
        data.add(new ItemCheckbox("Cancelled", false));
        list.add(new ItemCategoryFilter("Status", data));
        switch (categoryFilter){

            case "SortBy":

                list.remove(1);
                break;
            case "Status":

                list.remove(0);
                break;
        }



//        data = new ArrayList<>();
//        data.add(new ItemCheckbox("Last 30 days", false));
//        data.add(new ItemCheckbox("Last 3 months", false));
//        data.add(new ItemCheckbox("Last 6 months", false));
//        list.add(new ItemCategoryFilter("Date Range", data));

        adapter = new CategoryFilterAdapter(FilterActivity.this, new FilterInterface() {
            @Override
            public void onClickChecked(TextView label, boolean checkBox) {
                onAddClickChecked(label.getText().toString(), checkBox);
            }
        });

        adapter.setData(list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(FilterActivity.this, LinearLayoutManager.VERTICAL, false);
        rcvFilter.setLayoutManager(linearLayoutManager);
        rcvFilter.setHasFixedSize(true);
        rcvFilter.setAdapter(adapter);
    }

    private void onAddClickChecked(String label, boolean checkBox) {
    }

    private void initWidgets() {

        rcvFilter = findViewById(R.id.rcvFilter);
        imgBack = findViewById(R.id.imgBack);
        btnApply = findViewById(R.id.btnApply);

        Intent intent = getIntent();
        categoryFilter = intent.getStringExtra("filter");

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.imgBack:

                onBackPressed();

                break;

            case R.id.btnApply:


                break;
        }

    }
}