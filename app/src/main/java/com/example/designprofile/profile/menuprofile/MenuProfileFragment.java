package com.example.designprofile.profile.menuprofile;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.designprofile.R;
import com.example.designprofile.profile.menuprofile.account.AccountActivity;
import com.example.designprofile.profile.menuprofile.membership.MembershipActivity;
import com.example.designprofile.profile.menuprofile.membershipcard.MembershipCardActivity;
import com.example.designprofile.profile.menuprofile.myactivities.MyActivitiesActivity;
import com.example.designprofile.profile.menuprofile.reddeempoints.RedeemPointsActivity;
import com.example.designprofile.profile.menuprofile.refer.ReferActivity;
import com.example.designprofile.profile.menuprofile.setting.SettingsActivity;
import com.example.designprofile.profile.menuprofile.support.SupportActivity;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;

public class MenuProfileFragment extends BottomSheetDialogFragment implements View.OnClickListener{

    private RecyclerView rcvMenuProfile;
    private LinearLayout linInfo;
    private LinearLayout linRefer;
    private TextView txtTapToView;
    private TextView txtPoints;

    private View view = null;

    private ArrayList<ItemMenuProfile> listMenu;
    private MenuProfileAdapter adapterMenu;


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) super.onCreateDialog(savedInstanceState);

        view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_menu_profile, null);

        bottomSheetDialog.setContentView(view);

        initWidgets();

        setAllData();

        eventWidgets();

        return bottomSheetDialog;
    }

    private void eventWidgets() {

        txtTapToView.setOnClickListener(this);
        linInfo.setOnClickListener(this);
        linRefer.setOnClickListener(this);

    }

    private void setAllData() {

        setDataMenuProfile();

        setFullScreen();

    }

    private void setFullScreen() {

        BottomSheetBehavior behavior = BottomSheetBehavior.from((View) view.getParent());
        behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            linInfo.setBackgroundColor(getColorWithAlpha(view.getContext().getColor(R.color.color_black_1),0.4f));
            txtTapToView.setBackgroundColor(getColorWithAlpha(view.getContext().getColor(R.color.color_gray_4),0.45f));
        }
    }

    private int getColorWithAlpha(int color, float ratio) {
        int newColor = 0;
        int alpha = Math.round(Color.alpha(color) * ratio);
        int r = Color.red(color);
        int g = Color.green(color);
        int b = Color.blue(color);
        newColor = Color.argb(alpha, r, g, b);
        return newColor;
    }

    private void setDataMenuProfile() {

        listMenu = new ArrayList<>();

        listMenu = getDataMenu();

        adapterMenu = new MenuProfileAdapter(view.getContext(), new MenuProfileInterface() {
            @Override
            public void onClickListener(int position) {
                setOnClickMenu(position);
            }
        });

        adapterMenu.setData(listMenu);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(view.getContext(), 3, GridLayoutManager.VERTICAL, false);
        rcvMenuProfile.setLayoutManager(gridLayoutManager);
        rcvMenuProfile.setHasFixedSize(true);

        rcvMenuProfile.setAdapter(adapterMenu);
    }

    private void setOnClickMenu(int position) {
        Intent intent = null;
        switch (position){

            case 0:

                intent = new Intent(view.getContext(),AccountActivity.class);
                break;

            case 1:

                break;

            case 2:

                intent = new Intent(view.getContext(), MembershipActivity.class);

                break;
            case 3:

                intent = new Intent(view.getContext(), MyActivitiesActivity.class);

                break;
            case 4:

                break;
            case 5:

                break;
            case 6:

                break;
            case 7:

                break;
            case 8:
                intent = new Intent(view.getContext(), SettingsActivity.class);
                break;
            case 9:
                intent = new Intent(view.getContext(), SupportActivity.class);
                break;
            case 10:

                break;
        }

        if(intent != null){
            startActivity(intent);
        }

    }

    private ArrayList<ItemMenuProfile> getDataMenu() {

        ArrayList<ItemMenuProfile> list = new ArrayList<>();

        list.add(new ItemMenuProfile(R.mipmap.icon_account, view.getContext().getResources().getString(R.string.text_account)));
        list.add(new ItemMenuProfile(R.mipmap.icon_member_360_data, view.getContext().getResources().getString(R.string.text_member_360_data)));
        list.add(new ItemMenuProfile(R.mipmap.icon_membership, view.getContext().getResources().getString(R.string.text_membership)));
        list.add(new ItemMenuProfile(R.mipmap.icon_my_activities, view.getContext().getResources().getString(R.string.text_my_activities)));
        list.add(new ItemMenuProfile(R.mipmap.icon_my_favourites, view.getContext().getResources().getString(R.string.text_my_favourites)));
        list.add(new ItemMenuProfile(R.mipmap.icon_calendar, view.getContext().getResources().getString(R.string.text_calendar)));
        list.add(new ItemMenuProfile(R.mipmap.icon_shopping_address, view.getContext().getResources().getString(R.string.text_shopping_address)));
        list.add(new ItemMenuProfile(R.mipmap.icon_payment_details, view.getContext().getResources().getString(R.string.text_payment_details)));
        list.add(new ItemMenuProfile(R.mipmap.icon_settings, view.getContext().getResources().getString(R.string.text_settings)));
        list.add(new ItemMenuProfile(R.mipmap.icon_support, view.getContext().getResources().getString(R.string.text_support)));
        list.add(new ItemMenuProfile(R.mipmap.icon_logout, view.getContext().getResources().getString(R.string.text_logout)));

        return list;
    }

    private void initWidgets() {
        linRefer = view.findViewById(R.id.linRefer);
        rcvMenuProfile = view.findViewById(R.id.rcvMenuProfile);
        linInfo = view.findViewById(R.id.linInfo);
        txtTapToView = view.findViewById(R.id.txtTapToView);
        txtPoints = view.findViewById(R.id.txtPoints);
    }

    @Override
    public void onClick(View view) {

        Intent intent = null;
        switch (view.getId()){
            case R.id.txtTapToView:

                intent = new Intent(view.getContext(), MembershipCardActivity.class);

                break;

            case R.id.linInfo:

                intent = new Intent(view.getContext(), RedeemPointsActivity.class);
                break;

            case R.id.linRefer:

                intent = new Intent(view.getContext(), ReferActivity.class);
                break;
        }

        if (intent != null){
            startActivity(intent);
        }
    }
}
