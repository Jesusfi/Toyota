package com.example.jesusizquierdo.toyota;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.jesusizquierdo.toyota.classes.Engine;
import com.example.jesusizquierdo.toyota.rvadapters.ColorRvAdapter;
import com.example.jesusizquierdo.toyota.rvadapters.EngineRVAdapter;

import java.util.ArrayList;

public class CarSpecificsActivity extends AppCompatActivity {
ArrayList<Engine> engines;
    ArrayList<Integer> color;
    ImageView carView;
    RecyclerView recyclerView, recyclerViewColor;
    EngineRVAdapter engineRVAdapter;
    ColorRvAdapter colorRvAdapter;
    ImageView bigImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_specifics);

        carView = (ImageView) findViewById(R.id.car_image_specifics);
        recyclerView = (RecyclerView) findViewById(R.id.rv_for_engines);
        recyclerViewColor = (RecyclerView) findViewById(R.id.rv_for_color);




        int carSelected = getIntent().getIntExtra("car",0);
        engines = new ArrayList<>();
        color = new ArrayList<>();
        Toast.makeText(CarSpecificsActivity.this, ""+carSelected, Toast.LENGTH_SHORT).show();

        switch (carSelected){
            case 1:
                carView.setImageResource(R.drawable.carle);
                engines.add(new Engine("2.5L 4-Cyl. Hybrid Enigne","Electronically controlled Continuously Variavle Transmission","2000 Hybrid system net hp (149kW","Dual VVT-i"));
                color.add(R.drawable.camery_black);
                color.add(R.drawable.camery_red);
                color.add(R.drawable.camery_blue);
                break;
            case 2:
                Toast.makeText(CarSpecificsActivity.this, "Not done yet", Toast.LENGTH_SHORT).show();
                break;

        }
        engineRVAdapter = new EngineRVAdapter(this,engines);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(engineRVAdapter);

        colorRvAdapter = new ColorRvAdapter(this, color);
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewColor.setLayoutManager(linearLayoutManager1);
        recyclerViewColor.setAdapter(colorRvAdapter);



    }
    public void setImage(int imageNum){

        carView.setImageResource(imageNum);

    }
}
