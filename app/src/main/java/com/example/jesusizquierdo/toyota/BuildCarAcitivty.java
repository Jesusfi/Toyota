package com.example.jesusizquierdo.toyota;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class BuildCarAcitivty extends AppCompatActivity {
    int carSelected = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_build_car_acitivty);
        final LinearLayout carOne = (LinearLayout) findViewById(R.id.car1);
        final LinearLayout carTwo = (LinearLayout) findViewById(R.id.car2);
        carTwo.setBackgroundColor(Color.parseColor("#FFFFFF"));
        carOne.setBackgroundColor(Color.parseColor("#ADD8E6"));
        carOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(carSelected == 1){

                }else{
                    carSelected = 1;
                    carOne.setBackgroundColor(Color.parseColor("#ADD8E6"));
                    carTwo.setBackgroundColor(Color.parseColor("#FFFFFF"));
                }
            }
        });
        carTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            if(carSelected == 2){

            }else{
                carSelected = 2;
                carTwo.setBackgroundColor(Color.parseColor("#ADD8E6"));
                carOne.setBackgroundColor(Color.parseColor("#FFFFFF"));
            }
            }
        });

        Button select = (Button) findViewById(R.id.button_select_car);
        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    Intent intent = new Intent(BuildCarAcitivty.this, CarSpecificsActivity.class);
                    intent.putExtra("car",carSelected);
                    startActivity(intent);

            }
        });
    }
}
