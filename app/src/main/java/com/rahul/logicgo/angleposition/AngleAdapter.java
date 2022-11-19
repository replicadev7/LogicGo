package com.rahul.logicgo.angleposition;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rahul.logicgo.R;

import java.util.ArrayList;

public class AngleAdapter extends RecyclerView.Adapter<AngleAdapter.ViewHolder> {

    Context context;
    ArrayList<AngleModel> arrayList;
    public AngleAdapter(Context context, ArrayList<AngleModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.angle_item_box,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        AngleModel data = arrayList.get(position);
    if (data.isSelected()){
        holder.box.setBackgroundColor(context.getResources().getColor(R.color.purple_700));
    }else {
        holder.box.setBackgroundColor(context.getResources().getColor(R.color.black));
    }

    holder.itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            for (int i = 0; i < arrayList.size(); i++) {
               arrayList.get(i).setSelected(false);
            }
            for (int i = 0; i < arrayList.size() ; i++) {
                if (data.getFirstValue()>= arrayList.get(i).getFirstValue() && data.getSecondValue()>= arrayList.get(i).getSecondValue())
                    arrayList.get(i).setSelected(true);
            }
            notifyDataSetChanged();

        }
    });




    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView box;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            box = itemView.findViewById(R.id.btn_box);
        }
    }
}
