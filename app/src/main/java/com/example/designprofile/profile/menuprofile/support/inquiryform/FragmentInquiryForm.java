package com.example.designprofile.profile.menuprofile.support.inquiryform;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.designprofile.R;

public class FragmentInquiryForm extends Fragment {

    private View view = null;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_inquiry_form, container, false);
        Log.d("AAA","Inquiry Form");
        return view;

    }
}
