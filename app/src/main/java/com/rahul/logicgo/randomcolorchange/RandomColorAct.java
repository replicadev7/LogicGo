package com.rahul.logicgo.randomcolorchange;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.rahul.logicgo.databinding.ActivityMainBinding;
import com.rahul.logicgo.databinding.ActivityRandomColorBinding;

import java.util.ArrayList;

public class RandomColorAct extends AppCompatActivity {

    ActivityRandomColorBinding binding;
    ArrayList<RandomModel> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityRandomColorBinding.inflate(getLayoutInflater());
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
                           arrayList.add(new RandomModel(i,false,true));
                       }else {
                           arrayList.add(new RandomModel(i,false,false));
                       }
                   }
                   RandomNumberAdapter randomNumberAdapter = new RandomNumberAdapter(RandomColorAct.this,arrayList);
                   binding.recyclerview.setLayoutManager(new GridLayoutManager(RandomColorAct.this,4));
                   binding.recyclerview.setAdapter(randomNumberAdapter);

               }
           }
       });


    }
    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}