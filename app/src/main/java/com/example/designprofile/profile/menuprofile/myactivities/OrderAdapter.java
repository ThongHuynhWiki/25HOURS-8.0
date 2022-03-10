package com.example.designprofile.profile.menuprofile.myactivities;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.designprofile.R;

import java.util.List;


public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder>{

    private Context context;
    private List<ItemOrder> list;
    private OrderInterface orderInterface;

    public OrderAdapter(Context context, OrderInterface orderInterface) {
        this.context = context;
        this.orderInterface = orderInterface;
    }

    public void setData(List<ItemOrder> list, LinearLayout linNoOrder){
        if (list.size() > 0){
            linNoOrder.setVisibility(View.GONE);
        }else {
            linNoOrder.setVisibility(View.VISIBLE);
        }
        this.list = list;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_order_my_activities, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ItemOrder data = list.get(position);

        if (data == null){
            return;
        }

        holder.txtOrderID.setText("Order #" +  data.getOrderID());
        holder.txtStatus.setText(data.getStatus());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, RecyclerView.VERTICAL, false);
        holder.rcvProduct.setLayoutManager(linearLayoutManager);
        ProductAdapter productAdapter = new ProductAdapter(context);
        productAdapter.setData(data.getProductList());
        holder.rcvProduct.setAdapter(productAdapter);

        if (data.getStatus().equals("Completed") || data.getStatus().equals("Cancelled")){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                holder.txtStatus.setTextColor(context.getColor(R.color.color_gray_4));
            }
        }


        holder.txtOrderID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orderInterface.onClickListener(data);
            }
        });

    }

    @Override
    public int getItemCount() {

        if (list != null){
            return list.size();
        }

        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView txtOrderID;
        private TextView txtStatus;
        private RecyclerView rcvProduct;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtOrderID = itemView.findViewById(R.id.txtOrderID);
            txtStatus = itemView.findViewById(R.id.txtStatus);
            rcvProduct = itemView.findViewById(R.id.rcvListProductChildOrder);
        }
    }


}
