package com.example.designprofile.profile.menuprofile.support;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.designprofile.R;

import java.util.ArrayList;

public class SupportActivity extends AppCompatActivity {

    private ArrayList<String> list;
    private MenuAdapter menuAdapter;
    private RecyclerView rcvMenu;
    private TextView txtLabelPrevious;
    private RelativeLayout relLinePrevious;

    private SupportAdapter supportAdapter;
    private ViewPager2 vpgMenuSupport;

    private int curentMenu = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support);

        initWidgets();

        setAllData();

        eventWidgets();
    }

    private void eventWidgets() {

    }

    private void setAllData() {

        setDataMenu();

        setFragmentBody();
    }

    private ArrayList<String> getListDataMenu() {
        ArrayList<String> data = new ArrayList<>();

        data.add("FAQs");
        data.add("Inquiry From");

        return data;
    }

    private void setDataMenu() {
        list = new ArrayList<>();
        list = getListDataMenu();
        menuAdapter = new MenuAdapter(SupportActivity.this, new MenuInferface() {
            @Override
            public void onClickListener(TextView textView, RelativeLayout relativeLayout, int position) {

                if (position != curentMenu){
                    onClickItemMenu(textView, relativeLayout, position);
                }

            }
        });
        menuAdapter.setData(list);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(SupportActivity.this,2, GridLayoutManager.VERTICAL, false);

        rcvMenu.setLayoutManager(gridLayoutManager);
        rcvMenu.setHasFixedSize(true);
        rcvMenu.setAdapter(menuAdapter);

    }

    private void onClickItemMenu(TextView textView, RelativeLayout relativeLayout, int position) {
            setBackgroundSelected(textView, relativeLayout, position);
            vpgMenuSupport.setCurrentItem(position);
//                if(txtLabelPrevious != textView && relativeLayout != relLinePrevious){
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
        }

    private void setBackgroundSelected(TextView textView, RelativeLayout relativeLayout, int position) {

        curentMenu = position;
        textView.setTextColor(getResources().getColor(R.color.color_yellow_1));
        relativeLayout.setBackgroundColor(getResources().getColor(R.color.color_yellow_1));


        if (txtLabelPrevious == null && relLinePrevious == null){
            txtLabelPrevious = (TextView) rcvMenu.findViewHolderForLayoutPosition(0).itemView.findViewById(R.id.txtLabel);
            relLinePrevious = (RelativeLayout) rcvMenu.findViewHolderForLayoutPosition(0).itemView.findViewById(R.id.relLine);
        }

        txtLabelPrevious.setTextColor(getResources().getColor(R.color.color_gray_4));
        relLinePrevious.setBackgroundColor(getResources().getColor(R.color.color_gray_2));

        txtLabelPrevious = textView;
        relLinePrevious = relativeLayout;

    }

    private void setFragmentBody() {
        supportAdapter = new SupportAdapter(this);
        vpgMenuSupport.setAdapter(supportAdapter);
    }


    private void initWidgets() {

        vpgMenuSupport = findViewById(R.id.vpgMenuSupport);
        rcvMenu = findViewById(R.id.rcvMenu);
    }
}