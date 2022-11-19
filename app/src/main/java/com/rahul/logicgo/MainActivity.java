package com.rahul.logicgo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.rahul.logicgo.angleposition.AngleMainAct;
import com.rahul.logicgo.databinding.ActivityMainBinding;
import com.rahul.logicgo.randomcolorchange.RandomColorAct;
import com.rahul.logicgo.staticrandomcolor.StaticRandomColor;

public class MainActivity extends AppCompatActivity {


        ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        binding.btnAngle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AngleMainAct.class);
                startActivity(intent);
            }
        });

        binding.btnRandomColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RandomColorAct.class);
                startActivity(intent);
            }
        });

        binding.btnStaticColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, StaticRandomColor.class);
                startActivity(intent);
            }
        });

    }
}