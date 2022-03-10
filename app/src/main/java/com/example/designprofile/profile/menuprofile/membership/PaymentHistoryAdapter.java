package com.example.designprofile.profile.menuprofile.membership;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.designprofile.profile.menuprofile.myactivities.MenuInferface;
import com.example.designprofile.profile.root.RootApplication;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.designprofile.R;

import java.util.List;

public class PaymentHistoryAdapter extends RecyclerView.Adapter<PaymentHistoryAdapter.ViewHolder>{

    private Context context;
    private List<ItemPaymentHistory> list;

    public PaymentHistoryAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<ItemPaymentHistory> list){
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_payment_history,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        ItemPaymentHistory data = list.get(position);

        if(data == null){
            return;
        }

        holder.txtMembershipFee.setText(context.getResources().getString(R.string.text_label_membership_fee) + " - $" + RootApplication.setDollar(data.getMembershipFee()));
        holder.txtDate.setText(data.getDate());

    }

    @Override
    public int getItemCount() {
        if (list != null){
            return list.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView txtMembershipFee;
        private TextView txtDate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtMembershipFee = itemView.findViewById(R.id.txtMembershipFee);
            txtDate = itemView.findViewById(R.id.txtDate);
        }
    }
}
