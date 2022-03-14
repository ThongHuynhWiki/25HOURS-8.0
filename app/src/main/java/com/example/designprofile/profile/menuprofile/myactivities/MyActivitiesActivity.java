package com.example.designprofile.profile.menuprofile.myactivities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.designprofile.R;
import com.example.designprofile.profile.menuprofile.myactivities.filter.FilterActivity;
import com.example.designprofile.profile.menuprofile.myactivities.orderdetails.OrderDetailActivity;

import java.io.Serializable;
import java.util.ArrayList;

public class MyActivitiesActivity extends AppCompatActivity implements View.OnClickListener{

    private ArrayList<String> list;
    private MenuAdapter menuAdapter;
    private RecyclerView rcvMenu;

    private TextView btnTagAll;
    private TextView btnTagShortBy;
    private TextView btnTagStatus;

    private RecyclerView rcvOrder;
    private ArrayList<ItemOrder> listOrder;
    private OrderAdapter orderAdapter;

    private LinearLayout linNoOrder;

    private final int REQUEST_CODE_FILTER = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_activities);

        initWidgets();

        setAllData();

        eventWidgets();
    }

    private void eventWidgets() {

        btnTagAll.setOnClickListener(this);

        btnTagShortBy.setOnClickListener(this);

        btnTagStatus.setOnClickListener(this);
    }

    private void setAllData() {
        setMenuData();

        setOrderData();
    }

    private void setOrderData() {

        listOrder = new ArrayList<>();

        listOrder = getListOrder();

        orderAdapter = new OrderAdapter(MyActivitiesActivity.this, new OrderInterface() {
            @Override
            public void onClickListener(ItemOrder data) {
                onClickItemOrder(data);
            }
        });


        orderAdapter.setData(listOrder, linNoOrder);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MyActivitiesActivity.this, RecyclerView.VERTICAL, false);
        rcvOrder.setLayoutManager(linearLayoutManager);
        rcvOrder.setHasFixedSize(true);
        rcvOrder.setAdapter(orderAdapter);
    }

    private void onClickItemOrder(ItemOrder data) {

        Intent intent = new Intent(MyActivitiesActivity.this, OrderDetailActivity.class);
        intent.putExtra("data", data.getOrderID());
        startActivity(intent);
        
    }

    private ArrayList<ItemOrder> getListOrder() {

        ArrayList<ItemOrder> orders = new ArrayList<>();
        ArrayList<ItemProduct> data = new ArrayList<>();

        data.add(new ItemProduct(R.drawable.product, "Musk Melon", 110.3f, 11, 1));
        data.add(new ItemProduct(R.drawable.product, "Boiled Snow Crab Meat Flakes - Approx 200g/pack", 34.5f, 3, 2));
        orders.add(new ItemOrder("000002453354", "Orders", data));

        data = new ArrayList<>();
        data.add(new ItemProduct(R.drawable.product, "Frozen Kagoshima/Miyazaki Pork Yakiniku - 250g", 14, 1, 3));
        orders.add(new ItemOrder("000002453350", "Not delivered", data));

        data = new ArrayList<>();
        data.add(new ItemProduct(R.drawable.product, "Frozen Kagoshima/Miyazaki Pork Yakiniku - 250g", 14, 1, 3));
        orders.add(new ItemOrder("000002453340", "Cancelled", data));

        data = new ArrayList<>();
        data.add(new ItemProduct(R.drawable.product, "Frozen Kagoshima/Miyazaki Pork Yakiniku - 250g", 14, 1, 3));
        orders.add(new ItemOrder("000002453200", "Completed", data));

        return orders;
    }

    private void setMenuData() {
        list = new ArrayList<>();
        list = getListDataMenu();
        menuAdapter = new MenuAdapter(MyActivitiesActivity.this, new MenuInferface() {
            @Override
            public void onClickListener(TextView textView, RelativeLayout relativeLayout) {
                onClickItemMenu(textView, relativeLayout);
            }
        });
        menuAdapter.setData(list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MyActivitiesActivity.this, LinearLayoutManager.HORIZONTAL, false);

        rcvMenu.setLayoutManager(linearLayoutManager);
        rcvMenu.setHasFixedSize(true);
        rcvMenu.setAdapter(menuAdapter);
    }

    private void onClickItemMenu(TextView textView, RelativeLayout relativeLayout) {

//        if(txtLabelPrevious != textView && relativeLayout != relLinePrevious){
//            textView.setTextColor(getResources().getColor(R.color.color_yellow_1));
//            relativeLayout.setBackgroundColor(getResources().getColor(R.color.color_yellow_1));
//
//            if (txtLabelPrevious !=null && relLinePrevious !=null){
//                txtLabelPrevious.setTextColor(getResources().getColor(R.color.color_gray_4));
//                relLinePrevious.setBackgroundColor(getResources().getColor(R.color.color_gray_2));
//                txtLabelPrevious = textView;
//                relLinePrevious = relativeLayout;
//            }else{
//                txtLabelPrevious =  rcvMenu.findViewHolderForLayoutPosition(0).itemView.findViewById(R.id.txtLabel);
//                relLinePrevious = rcvMenu.findViewHolderForLayoutPosition(0).itemView.findViewById(R.id.relLine);
//                txtLabelPrevious.setTextColor(getResources().getColor(R.color.color_gray_4));
//                relLinePrevious.setBackgroundColor(getResources().getColor(R.color.color_gray_2));
//            }
//        }


    }

    private ArrayList<String> getListDataMenu() {
        ArrayList<String> data = new ArrayList<>();
        data.add("Shop");
        return data;
    }

    private void initWidgets() {
        btnTagAll = findViewById(R.id.btnTagAll);
        btnTagStatus = findViewById(R.id.btnTagStatus);
        btnTagShortBy = findViewById(R.id.btnTagSortBy);
        rcvMenu = findViewById(R.id.rcvMenu);
        rcvOrder = findViewById(R.id.rcvOrder);
        linNoOrder = findViewById(R.id.linNoOrder);
    }

    @Override
    public void onClick(View view) {

        Intent intent = null;
        intent = new Intent(MyActivitiesActivity.this, FilterActivity.class);
        switch (view.getId()){
            case R.id.btnTagAll:

                intent.putExtra("filter","All");
                break;

            case R.id.btnTagSortBy:
                intent.putExtra("filter","SortBy");
                break;
            case R.id.btnTagStatus:
                intent.putExtra("filter","Status");
                break;
        }

        if (intent != null){
            startActivityForResult(intent, REQUEST_CODE_FILTER);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE_FILTER && resultCode == Activity.RESULT_OK && data != null){

        }
    }
}