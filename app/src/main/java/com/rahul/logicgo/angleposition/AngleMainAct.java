package com.rahul.logicgo.angleposition;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.rahul.logicgo.databinding.ActivityAngleMainBinding;

import java.util.ArrayList;

public class AngleMainAct extends AppCompatActivity {

    ActivityAngleMainBinding binding;
    ArrayList<AngleModel> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAngleMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        arrayList = new ArrayList<>();

        binding.btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!binding.editTv.getText().toString().isEmpty()){
                    arrayList.clear();
                    int num= Integer.parseInt(binding.editTv.getText().toString());
                    for (int i = 0; i < num; i++) {
                        for (int j = 0; j < num ; j++) {
                            arrayList.add(new AngleModel(i,j,false));
                        }
                    }

                    Log.e("rrr", "onClick-----: "+arrayList.size());

                    AngleAdapter randomNumberAdapter = new AngleAdapter(AngleMainAct.this,arrayList);
                    binding.recyclerview.setLayoutManager(new GridLayoutManager(AngleMainAct.this,num));
                    binding.recyclerview.setAdapter(randomNumberAdapter);

                }
            }
        });
    }
}