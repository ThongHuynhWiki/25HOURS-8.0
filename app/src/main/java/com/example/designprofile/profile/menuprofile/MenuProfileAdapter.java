package com.example.designprofile.profile.menuprofile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.designprofile.R;

import java.util.List;

public class MenuProfileAdapter extends RecyclerView.Adapter<MenuProfileAdapter.ViewHolder>{

    private MenuProfileInterface menuProfileInterface;
    private List<ItemMenuProfile> list;
    private Context context;

    public MenuProfileAdapter(Context context, MenuProfileInterface menuProfileInterface) {
        this.context = context;
        this.menuProfileInterface = menuProfileInterface;

    }

    public void setData(List<ItemMenuProfile> list){
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_menu_profile,parent,false);

        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ItemMenuProfile data = list.get(position);

        if(data == null){
            return;
        }

        holder.icon.setImageResource(data.getLogo());
        holder.name.setText(data.getContent());

        holder.relMenuMainItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                menuProfileInterface.onClickListener(holder.getLayoutPosition());

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

        private ImageView icon;
        private TextView name;
        private RelativeLayout relMenuMainItem;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            icon = itemView.findViewById(R.id.imgIcon);
            name = itemView.findViewById(R.id.txtName);
            relMenuMainItem = itemView.findViewById(R.id.relMenuMainItem);
        }

    }
}
