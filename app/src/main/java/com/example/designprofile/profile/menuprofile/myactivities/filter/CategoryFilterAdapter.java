package com.example.designprofile.profile.menuprofile.myactivities.filter;

import android.content.Context;
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
import com.example.designprofile.profile.menuprofile.myactivities.ItemOrder;
import com.example.designprofile.profile.menuprofile.myactivities.OrderAdapter;
import com.example.designprofile.profile.menuprofile.myactivities.OrderInterface;
import com.example.designprofile.profile.menuprofile.myactivities.ProductAdapter;

import java.util.List;

public class CategoryFilterAdapter extends RecyclerView.Adapter<CategoryFilterAdapter.ViewHolder>{

    private Context context;
    private List<ItemCategoryFilter> list;
    private FilterInterface filterInterface;

    public CategoryFilterAdapter(Context context, FilterInterface filterInterface) {
        this.context = context;
        this.filterInterface = filterInterface;
    }

    public void setData(List<ItemCategoryFilter> list){
        this.list = list;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category_filter, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ItemCategoryFilter data = list.get(position);

        if (data == null){
            return;
        }

        holder.txtTitle.setText(data.getTitle());

        ListCheckboxAdapter adapter = new ListCheckboxAdapter(context, new FilterInterface() {
            @Override
            public void onClickChecked(TextView label, boolean checkBox) {
                filterInterface.onClickChecked(label, checkBox);
            }
        });

        adapter.setData(data.getList());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context,LinearLayoutManager.VERTICAL, false);
        holder.rcvFilter.setLayoutManager(linearLayoutManager);
        holder.rcvFilter.setHasFixedSize(true);
        holder.rcvFilter.setAdapter(adapter);
    }

    @Override
    public int getItemCount() {

        if (list != null){
            return list.size();
        }

        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView txtTitle;
        private RecyclerView rcvFilter;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtTitle = itemView.findViewById(R.id.txtTitle);
            rcvFilter = itemView.findViewById(R.id.rcvFilter);
        }
    }
}
