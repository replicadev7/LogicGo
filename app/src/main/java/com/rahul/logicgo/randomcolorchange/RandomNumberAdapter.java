package com.rahul.logicgo.randomcolorchange;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rahul.logicgo.R;

import java.util.ArrayList;

public class RandomNumberAdapter extends RecyclerView.Adapter<RandomNumberAdapter.ViewHolder> {

    Context context;
    ArrayList<RandomModel> arrayList;

    public RandomNumberAdapter(Context context, ArrayList<RandomModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.random_box_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        RandomModel data = arrayList.get(position);
        if (data.getRed()) {
            holder.box.setBackgroundColor(context.getResources().getColor(R.color.red));
        } else if (data.isSelected()) {
            holder.box.setBackgroundColor(context.getResources().getColor(R.color.purple_700));
        } else {
            holder.box.setBackgroundColor(context.getResources().getColor(R.color.black));
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (arrayList.get(position).isSelected() && !arrayList.get(position).getRed()) {
                    arrayList.get(position).setRed(true);
                    ArrayList<RandomModel> dataArrayList = new ArrayList<>();
                    for (int i = 0; i <arrayList.size() ; i++) {
                        if (!arrayList.get(i).isSelected()) {
                            dataArrayList.add(arrayList.get(i));
                        }
                    }
                    if (dataArrayList.size() == 0) {
                        holder.box.setBackgroundColor(context.getResources().getColor(R.color.red));
                        notifyDataSetChanged();
                        Toast.makeText(context, "all", Toast.LENGTH_SHORT).show();
                    } else {
                        int random = getRandomNumber(0, dataArrayList.size());
                        RandomModel data1 = dataArrayList.get(random);

                        arrayList.get(data1.blueItemPosition).setSelected(true);

                        notifyDataSetChanged();
                    }

                }
            }
        });
    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
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
