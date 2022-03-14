package com.example.designprofile.profile.menuprofile.setting.selectsetting;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.designprofile.R;
import com.example.designprofile.profile.menuprofile.setting.selectsetting.ItemSetting;
import com.example.designprofile.profile.menuprofile.setting.selectsetting.SelectSettingAdapter;

import java.util.ArrayList;

public class SelectSettingActivity extends AppCompatActivity {

    private RecyclerView rcvListNotification;
    private ArrayList<ItemSetting> list;
    private SelectSettingAdapter adapter;
    private SwitchCompat swcCheckToggleAll;
    private RelativeLayout relTouchToggleAll;
    private TextView txtTitleSetting;
    private boolean isPushNotification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_setting);

        initWidgets();

        setAllData();

        eventWidgets();
    }

    private void eventWidgets() {

        swcCheckToggleAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickCheckNToggleAll();
            }
        });
    }

    private void onClickCheckNToggleAll() {

        for (int i=0; i < list.size(); i++){
            list.get(i).setCheck(swcCheckToggleAll.isChecked());
        }
        adapter.setData(list);


    }

    private void setAllData() {
        // set display
        // if isPushNotification == true -> Display Push Notification
        // else isPushNotification == false -> Display Biometric Settings

        if (!isPushNotification){
            relTouchToggleAll.setVisibility(View.GONE);
            txtTitleSetting.setText(getResources().getString(R.string.text_biometric_settings));
        }

        list = new ArrayList<>();

        list = getListNotification();

        adapter = new SelectSettingAdapter(SelectSettingActivity.this, new SelectSettingInterface() {

            @Override
            public void onClickCheckItemNotification(boolean isCheck, int position) {
                list.get(position).setCheck(isCheck);
                onClickItemListNotification(isCheck);
            }
        });

        adapter.setData(list);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(SelectSettingActivity.this, LinearLayoutManager.VERTICAL, false);

        rcvListNotification.setLayoutManager(linearLayoutManager);
        rcvListNotification.setHasFixedSize(true);

        rcvListNotification.setAdapter(adapter);

    }

    private void onClickItemListNotification(boolean isCheck) {
        if (isCheck == false){
            swcCheckToggleAll.setChecked(false);
        } else{
            if (swcCheckToggleAll.isChecked() == false ){
                int tamp = 0;
                for (int i=0; i < list.size(); i++){
                    if (list.get(i).isCheck() == true){
                        tamp++;
                    }else {
                        break;
                    }
                }

                if (tamp >= list.size()){
                    swcCheckToggleAll.setChecked(true);
                }
            }
        }


    }

    private ArrayList<ItemSetting> getListNotification() {

        ArrayList<ItemSetting> data = new ArrayList<>();

        if (isPushNotification){
            data.add(new ItemSetting("Marketing Alerts", true));
            data.add(new ItemSetting("Event Invites & Updates", false));
            data.add(new ItemSetting("Travel Deals", false));
            data.add(new ItemSetting("Wine & Dine Deals", true));
            data.add(new ItemSetting("Shopping Deals", false));
            data.add(new ItemSetting("eStore Deals", false));
            data.add(new ItemSetting("Wellness Deals", false));
        }else {
            data.add(new ItemSetting("Enable Touch ID", true));
        }

        return data;
    }

    private void initWidgets() {

        Intent intent = getIntent();
        isPushNotification = intent.getBooleanExtra("check", true);

        txtTitleSetting = findViewById(R.id.txtTitleSetting);
        relTouchToggleAll = findViewById(R.id.relTouchToggleAll);
        swcCheckToggleAll = findViewById(R.id.swToggleAll);
        rcvListNotification = findViewById(R.id.rcvListPushNotifications);
    }
}