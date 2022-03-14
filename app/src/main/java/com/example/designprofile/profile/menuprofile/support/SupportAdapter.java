package com.example.designprofile.profile.menuprofile.support;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.designprofile.profile.menuprofile.support.faqs.FragmentFAQS;
import com.example.designprofile.profile.menuprofile.support.inquiryform.FragmentInquiryForm;

public class SupportAdapter extends FragmentStateAdapter {


    public SupportAdapter(@NonNull FragmentActivity fragmentActivity) {

        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position){
            case 0:
                return new FragmentFAQS();
            case 1:

                return new FragmentInquiryForm();
            default:
                return new FragmentFAQS();
        }

    }

    @Override
    public int getItemCount() {
        return 2;
    }


}
