package com.example.designprofile.profile.menuprofile.myactivities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.designprofile.R;

import java.util.List;

import com.example.designprofile.profile.root.RootApplication;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder>{

    private List<ItemProduct> list;
    private Context context;

    public ProductAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<ItemProduct> list){
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product_child_order,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ItemProduct data = list.get(position);
        if (list == null){
            return;
        }

        Glide.with(context).load(data.getLogo()).into(holder.imgProduct);
        holder.txtPricePoints.setText("$" + RootApplication.setDollar(data.getPrice()) + "•" + data.getPoints() + "Points");
        holder.txtProductName.setText(data.getName());
        holder.txtQuantity.setText("Qty: " + data.getQuantity());
        holder.txtTotalMoney.setText("$" + RootApplication.setDollar(data.getPrice() * data.getQuantity()));
    }

    @Override
    public int getItemCount() {

        if (list!=null){
            return list.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgProduct;
        private TextView txtProductName;
        private TextView txtPricePoints;
        private TextView txtQuantity;
        private TextView txtTotalMoney;
        private TextView btnReorder;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgProduct = itemView.findViewById(R.id.txtImageProduct);
            txtProductName = itemView.findViewById(R.id.txtProductName);
            txtPricePoints = itemView.findViewById(R.id.txtPricePoints);
            txtQuantity = itemView.findViewById(R.id.txtQuantity);
            txtTotalMoney = itemView.findViewById(R.id.txtTotalMoney);
            btnReorder = itemView.findViewById(R.id.btnReorder);
        }
    }
}
