package com.example.designprofile.profile.menuprofile.support.inquiryform;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.designprofile.R;

public class FragmentInquiryForm extends Fragment implements View.OnClickListener{

    private View view = null;

    private TextView btnSubmit;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_inquiry_form, container, false);


        initWidget();

        eventWidget();

        return view;

    }

    private void eventWidget() {
        btnSubmit.setOnClickListener(this);
    }

    private void initWidget() {
        btnSubmit = view.findViewById(R.id.btnSubmit);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnSubmit:
                openSubmit();
                break;

        }
    }

    private void openSubmit() {

        final Dialog dialog = new Dialog(view.getContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_preview_inquiry_form_support);

        Window window = dialog.getWindow();

        if (window == null){
            return;
        }

        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        WindowManager.LayoutParams windowAttribtes = window.getAttributes();
        windowAttribtes.gravity = Gravity.CENTER;
        window.setAttributes(windowAttribtes);
        dialog.setCancelable(false);

        TextView btnOK = dialog.findViewById(R.id.btnOK);

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}
