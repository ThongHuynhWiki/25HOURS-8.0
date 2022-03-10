package com.example.designprofile.profile.menuprofile.myactivities.filter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.designprofile.R;

import java.util.List;

public class ListCheckboxAdapter extends RecyclerView.Adapter<ListCheckboxAdapter.ViewHolder>{

    private FilterInterface listCheckboxInterface;
    private List<ItemCheckbox> list;
    private Context context;

    public ListCheckboxAdapter(Context context, FilterInterface listCheckboxInterface) {
        this.listCheckboxInterface = listCheckboxInterface;
        this.context = context;
    }

    public void setData(List<ItemCheckbox> list){
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_filter_checkbox,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ItemCheckbox data = list.get(position);

        if (list == null){
            return;
        }

        holder.txtLabel.setText(data.getLabel());

        if (data.isCheck()){
            holder.ckbCheck.setChecked(true);
        }

        holder.ckbCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                listCheckboxInterface.onClickChecked(holder.txtLabel, b);
            }
        });
    }

    @Override
    public int getItemCount() {

        if (list!=null){
            return list.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView txtLabel;
        private CheckBox ckbCheck;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtLabel = itemView.findViewById(R.id.txtLabel);
            ckbCheck = itemView.findViewById(R.id.ckbCheck);
        }
    }



}
