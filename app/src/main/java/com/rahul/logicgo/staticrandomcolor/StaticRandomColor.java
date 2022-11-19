package com.rahul.logicgo.staticrandomcolor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.rahul.logicgo.databinding.ActivityMainBinding;
import com.rahul.logicgo.databinding.ActivityStaticRandomColorBinding;

import java.util.ArrayList;

public class StaticRandomColor extends AppCompatActivity {

    ActivityStaticRandomColorBinding binding;
    ArrayList<StaticData> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityStaticRandomColorBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        arrayList = new ArrayList<>();



        binding.btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayList.clear();
                if (!binding.editTv.getText().toString().isEmpty()){
                    int number = Integer.parseInt(binding.editTv.getText().toString());
                    int random=getRandomNumber(0,number);
                    for (int i = 0; i < number; i++) {
                        if (random == i){
                            arrayList.add(new StaticData(i,true,false));
                        }else {
                            arrayList.add(new StaticData(i,false,false));
                        }
                    }
                    StaticAdapter randomNumberAdapter = new StaticAdapter(StaticRandomColor.this,arrayList);
                    binding.recyclerview.setLayoutManager(new GridLayoutManager(StaticRandomColor.this,4));
                    binding.recyclerview.setAdapter(randomNumberAdapter);

                }
            }
        });

    }
    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}