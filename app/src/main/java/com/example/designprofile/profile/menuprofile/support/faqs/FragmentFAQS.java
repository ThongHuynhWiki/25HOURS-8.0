package com.example.designprofile.profile.menuprofile.support.faqs;

import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.designprofile.R;
import com.example.designprofile.profile.menuprofile.support.faqs.adapter.FAQsAdapter;
import com.example.designprofile.profile.menuprofile.support.faqs.adapter.FAQsInterface;
import com.example.designprofile.profile.root.RootApplication;

import java.util.ArrayList;
import java.util.List;

public class FragmentFAQS extends Fragment {

    private View view = null;
    private FAQsAdapter adapter;
    private RecyclerView rcvFAQs;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_faqs, container, false);

        initWidgets();

        setAllData();
        return view;
    }

    private void setAllData() {
        adapter = new FAQsAdapter(view.getContext(), new FAQsInterface() {
            @Override
            public void onClickListener(TextView tvTitle, TextView tvContent, ItemFAQs item) {
                onClickItem(tvTitle, tvContent, item);
            }
        });

        rcvFAQs.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        rcvFAQs.setLayoutManager(linearLayoutManager);
        rcvFAQs.setAdapter(adapter);
        adapter.setDataListItem(getListItem());
    }

    private void initWidgets() {
        rcvFAQs = view.findViewById(R.id.rcv_FAQs);

    }

    private void onClickItem(TextView tvTitle, TextView tvContent, ItemFAQs itemSupportModel) {
        if (itemSupportModel.isReaded()){
            RootApplication.setFont(view.getContext(), R.string.fonts_Jost_Light, tvTitle);
            tvContent.setVisibility(View.GONE);
        }else {
            RootApplication.setFont(view.getContext(), R.string.fonts_Jost_Medium, tvTitle);
            tvContent.setVisibility(View.VISIBLE);
        }

        itemSupportModel.setReaded(!itemSupportModel.isReaded());

    }

    private List<ItemFAQs> getListItem() {
        List<ItemFAQs> listItem = new ArrayList<>();
        listItem.add(new ItemFAQs("What is 25Hours?","25Hours exists as a solution for the modern, time-pressured individuals — products, services, people, experiences, and entertainment of the utmost quality that are meticulously selected to ensure that members are spending their precious spare time on nothing but enjoying the best that the world has to offer. ", false));
        listItem.add(new ItemFAQs("What are the benefits?","25Hours exists as a solution for the modern, time-pressured individuals — products, services, people, experiences, and entertainment of the utmost quality that are meticulously selected to ensure that members are spending their precious spare time on nothing but enjoying the best that the world has to offer. ", false));
        listItem.add(new ItemFAQs("I am interested in becoming a member of 25Hours. How do I get it?","25Hours exists as a solution for the modern, time-pressured individuals — products, services, people, experiences, and entertainment of the utmost quality that are meticulously selected to ensure that members are spending their precious spare time on nothing but enjoying the best that the world has to offer. ", false));
        listItem.add(new ItemFAQs("Is there any age limit to become a member?","25Hours exists as a solution for the modern, time-pressured individuals — products, services, people, experiences, and entertainment of the utmost quality that are meticulously selected to ensure that members are spending their precious spare time on nothing but enjoying the best that the world has to offer. ", false));
        listItem.add(new ItemFAQs("How much is the membership fee?","25Hours exists as a solution for the modern, time-pressured individuals — products, services, people, experiences, and entertainment of the utmost quality that are meticulously selected to ensure that members are spending their precious spare time on nothing but enjoying the best that the world has to offer. ", false));
        listItem.add(new ItemFAQs("Can I cancel my membership if I change my mind after signing-up?","25Hours exists as a solution for the modern, time-pressured individuals — products, services, people, experiences, and entertainment of the utmost quality that are meticulously selected to ensure that members are spending their precious spare time on nothing but enjoying the best that the world has to offer. ", false));
        listItem.add(new ItemFAQs("Which email can I contact for inquiries regarding the cessation of my Sky Premium Membership Programme?","25Hours exists as a solution for the modern, time-pressured individuals — products, services, people, experiences, and entertainment of the utmost quality that are meticulously selected to ensure that members are spending their precious spare time on nothing but enjoying the best that the world has to offer. ", false));
        listItem.add(new ItemFAQs("What is 25Hours?","25Hours exists as a solution for the modern, time-pressured individuals — products, services, people, experiences, and entertainment of the utmost quality that are meticulously selected to ensure that members are spending their precious spare time on nothing but enjoying the best that the world has to offer. ",false));
        listItem.add(new ItemFAQs("Will 25Hours offer the same products and services that Sky Premium had?","25Hours exists as a solution for the modern, time-pressured individuals — products, services, people, experiences, and entertainment of the utmost quality that are meticulously selected to ensure that members are spending their precious spare time on nothing but enjoying the best that the world has to offer. ", false));
        listItem.add(new ItemFAQs("Can I attend all events with the membership?","25Hours exists as a solution for the modern, time-pressured individuals — products, services, people, experiences, and entertainment of the utmost quality that are meticulously selected to ensure that members are spending their precious spare time on nothing but enjoying the best that the world has to offer. ", false));

        return listItem;

    }
}
