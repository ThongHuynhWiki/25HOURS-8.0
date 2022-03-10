package com.example.designprofile.profile.menuprofile.myactivities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.designprofile.R;

import java.util.ArrayList;
import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder>{

    private Context context;
    private ArrayList<String> list;
    private MenuInferface menuInferface;

    public MenuAdapter(Context context, MenuInferface menuInferface) {
        this.context = context;
        this.menuInferface = menuInferface;
    }

    public void setData(ArrayList<String> list){
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_menu_my_activities,parent,false);

            return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        String data = list.get(position);
        if(data == null){
            return;
        }

            holder.txtLabel.setText(data);

            if (position == 0){
                holder.txtLabel.setTextColor(context.getResources().getColor(R.color.color_yellow_1));
                holder.relLine.setBackgroundColor(context.getResources().getColor(R.color.color_yellow_1));
            }
            holder.linItemMenu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    menuInferface.onClickListener(holder.txtLabel, holder.relLine);
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

        private TextView txtLabel;
        private RelativeLayout relLine;
        private LinearLayout linItemMenu;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtLabel = itemView.findViewById(R.id.txtLabel);
            relLine = itemView.findViewById(R.id.relLine);
            linItemMenu = itemView.findViewById(R.id.linItemMenu);
        }
    }

}
