package com.example.designprofile.profile.menuprofile.support.faqs.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.designprofile.R;
import com.example.designprofile.profile.menuprofile.support.faqs.ItemFAQs;

import java.util.List;

public class FAQsAdapter extends RecyclerView.Adapter<FAQsAdapter.ViewHolder>{
    private List<ItemFAQs> listItem;
    private Context mContext;
    private FAQsInterface faQsInterface;

    public FAQsAdapter(Context mContext, FAQsInterface faQsInterface) {
        this.mContext = mContext;
        this.faQsInterface = faQsInterface;
    }

    public void setDataListItem(List<ItemFAQs> listItem){
        this.listItem = listItem;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_faqs,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ItemFAQs item = listItem.get(position);
        if(item == null){
            return;
        }
        holder.tvTitle.setText(item.getTitle());
        holder.tvContent.setText(item.getContent());

        holder.linearLayoutItemClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                faQsInterface.onClickListener(holder.tvTitle, holder.tvContent, item);
            }
        });
    }



    @Override
    public int getItemCount() {
        if (listItem != null){
            return listItem.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvTitle;
        TextView tvContent;
        LinearLayout linearLayoutItemClick;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            linearLayoutItemClick = itemView.findViewById(R.id.item_click);
            tvTitle = itemView.findViewById(R.id.txtTitle);
            tvContent = itemView.findViewById(R.id.txtContent);
        }
    }
}
