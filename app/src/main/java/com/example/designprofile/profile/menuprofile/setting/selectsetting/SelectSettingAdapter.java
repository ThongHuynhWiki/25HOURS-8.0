package com.example.designprofile.profile.menuprofile.setting.selectsetting;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SwitchCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.designprofile.R;

import java.util.List;

public class SelectSettingAdapter extends RecyclerView.Adapter<SelectSettingAdapter.ViewHolder>{

    private Context context;
    private List<ItemSetting> list;
    private SelectSettingInterface selectSettingInterface;

    private View view = null;

    public SelectSettingAdapter(Context context, SelectSettingInterface pushNotificationInterface) {
        this.context = context;
        this.selectSettingInterface = pushNotificationInterface;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_notification,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int pst = position;
        ItemSetting data = list.get(position);
        if(data == null){
            return;
        }

        holder.txtLabel.setText(data.getLabel());
        holder.swCheck.setChecked(data.isCheck());

        holder.swCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                selectSettingInterface.onClickCheckItemNotification(b, pst);
            }
        });
    }

    public void setData(List<ItemSetting> list){
        this.list = list;
        notifyDataSetChanged();
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
        private SwitchCompat swCheck;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtLabel = itemView.findViewById(R.id.txtLabel);
            swCheck = itemView.findViewById(R.id.swCheck);
        }
    }
}
