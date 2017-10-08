package com.example.jesusizquierdo.toyota;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jesusizquierdo.toyota.classes.Car;
import com.example.jesusizquierdo.toyota.classes.Engine;
import com.example.jesusizquierdo.toyota.rvadapters.ColorRvAdapter;
import com.example.jesusizquierdo.toyota.rvadapters.EngineRVAdapter;
import com.example.jesusizquierdo.toyota.classes.Package;
import com.example.jesusizquierdo.toyota.rvadapters.PackageRvAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class CarSpecificsActivity extends AppCompatActivity {
    ArrayList<Engine> engines;
    ArrayList<Integer> color;
    ArrayList<Package> packages;
    ImageView carView;
    RecyclerView recyclerView, recyclerViewColor,recyclerViewPackage;
    EngineRVAdapter engineRVAdapter;
    ColorRvAdapter colorRvAdapter;
    PackageRvAdapter packageRvAdapter;
    Button finishCar;
    TextView engineInCard,packageInCard;
    ImageView bigImage;
    // for car model
    String carModelName;
    int colorNumberGlobal = 0;
    String engineNameGlobal = "";
    String packageNameGlobal = "";
    //firebase tools
    FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_specifics);

        firebaseAuth = FirebaseAuth.getInstance();


        carView = (ImageView) findViewById(R.id.car_image_specifics);
        recyclerView = (RecyclerView) findViewById(R.id.rv_for_engines);
        recyclerViewColor = (RecyclerView) findViewById(R.id.rv_for_color);
        recyclerViewPackage = (RecyclerView) findViewById(R.id.rv_for_package);
        finishCar = (Button) findViewById(R.id.btn_finish_build);

        engineInCard = (TextView) findViewById(R.id.tv_engine_name_in_card);
        packageInCard = (TextView) findViewById(R.id.tv_package_in_card);

        int carSelected = getIntent().getIntExtra("car", 0);

        engines = new ArrayList<>();
        color = new ArrayList<>();
        packages = new ArrayList<>();

        Toast.makeText(CarSpecificsActivity.this, "" + carSelected, Toast.LENGTH_SHORT).show();

        switch (carSelected) {
            case 1:
                carModelName = "Camry";
                carView.setImageResource(R.drawable.carle);
                engines.add(new Engine("2.5L 4-Cyl. Hybrid Enigne", "Electronically controlled Continuously Variavle Transmission", "2000 Hybrid system net hp (149kW", "Dual VVT-i"));
                color.add(R.drawable.camery_black);
                color.add(R.drawable.camery_red);
                color.add(R.drawable.camery_blue);
                packages.add(new Package("Entune™ Premium Audio with Integrated Navigation","2,290","Power tilt/slide moonroof"));
                break;
            case 2:
                Toast.makeText(CarSpecificsActivity.this, "Not done yet", Toast.LENGTH_SHORT).show();
                break;

        }
        engineRVAdapter = new EngineRVAdapter(this, engines);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(engineRVAdapter);

        colorRvAdapter = new ColorRvAdapter(this, color);
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewColor.setLayoutManager(linearLayoutManager1);
        recyclerViewColor.setAdapter(colorRvAdapter);

        packageRvAdapter = new PackageRvAdapter(this,packages);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewPackage.setLayoutManager(linearLayoutManager2);
        recyclerViewPackage.setAdapter(packageRvAdapter);

        finishCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(engineNameGlobal)){
                    Toast.makeText(CarSpecificsActivity.this, "Please pick Engine", Toast.LENGTH_SHORT).show();
                }else if(TextUtils.isEmpty(packageNameGlobal)){
                    Toast.makeText(CarSpecificsActivity.this, "Please pick package", Toast.LENGTH_SHORT).show();
                }else if(colorNumberGlobal ==0){
                    Toast.makeText(CarSpecificsActivity.this, "Please pick a color", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(CarSpecificsActivity.this, "Everything looks good", Toast.LENGTH_SHORT).show();
                    Car car = new Car(carModelName,engineNameGlobal,colorNumberGlobal,packageNameGlobal);
                    saveCar(car);
                }
            }
        });

    }

    public void setImage(int imageNum) {

        carView.setImageResource(imageNum);
        colorNumberGlobal = imageNum;
    }

    public void setEngine(String engineName) {
        engineInCard.setText(engineName);
        engineNameGlobal  = engineName;
    }
    public  void setPackages(String packageName){
        packageInCard.setText(packageName);
        packageNameGlobal = packageName;
    }
    public void saveCar(Car car){
        FirebaseUser user = firebaseAuth.getCurrentUser();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("builds").child(user.getUid()).push();
        reference.setValue(car);
        //this is a change real quick
        // change database
        //nfc added
    }
}
