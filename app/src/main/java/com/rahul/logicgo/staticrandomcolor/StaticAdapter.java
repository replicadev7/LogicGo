package com.rahul.logicgo.staticrandomcolor;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rahul.logicgo.R;

import java.util.ArrayList;

public class StaticAdapter extends RecyclerView.Adapter<StaticAdapter.ViewHolder> {

    Context context;
    ArrayList<StaticData> arrayList;


    public StaticAdapter(Context context, ArrayList<StaticData> arrayList) {
        this.context = context;
        this.arrayList = arrayList;

    }

    @NonNull
    @Override
    public StaticAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.static_data_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StaticAdapter.ViewHolder holder, int position) {
        StaticData item = arrayList.get(position);
        if (item.getRed()) {
            Log.e("rrr", "onBindViewHolder--0000--: ");
            holder.btn_box.setBackgroundColor(context.getResources().getColor(R.color.red));
        } else if (item.isSelected()) {
            Log.e("rrr", "onBindViewHolder--111--: ");

            holder.btn_box.setBackgroundColor(context.getResources().getColor(R.color.purple_700));
        } else {
            holder.btn_box.setBackgroundColor(context.getResources().getColor(R.color.black));

        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (item.getRed()) {
                    ArrayList<StaticData> newArraylist = new ArrayList<>();
                    for (StaticData item1 : arrayList) {
                        if (!item1.isSelected()) {
                            newArraylist.add(item1);
                        }
                    }
                    if (newArraylist.size() == 0) {
                        holder.btn_box.setBackgroundColor(context.getResources().getColor(R.color.purple_700));
                        notifyDataSetChanged();
                        Toast.makeText(context, "All Blue", Toast.LENGTH_SHORT).show();
                    } else {
                        int random = getRandomNumber(0, newArraylist.size());
                        Log.i("yt--", "size -   >" + newArraylist.size());
                        StaticData newItem = newArraylist.get(random);
                        Log.i("yt--", "random-  >" + random + "--newItem.first-  >" + newItem.blueItemPosition);

                        arrayList.get(newItem.blueItemPosition).setSelected(true);
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
        TextView btn_box;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            btn_box = itemView.findViewById(R.id.btn_box);
        }
    }
}
