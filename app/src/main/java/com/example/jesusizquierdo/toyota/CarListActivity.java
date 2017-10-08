package com.example.jesusizquierdo.toyota;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.jesusizquierdo.toyota.classes.Car;
import com.example.jesusizquierdo.toyota.rvadapters.FirebaseCarViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CarListActivity extends AppCompatActivity {
    private DatabaseReference databaseReference;
    FirebaseAuth auth;
    RecyclerView recyclerView;
//finished car ui
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_car_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        recyclerView = (RecyclerView) findViewById(R.id.rv_for_firebase_cars);
        auth = FirebaseAuth.getInstance();
        FirebaseUser user = auth.getCurrentUser();
        databaseReference = FirebaseDatabase.getInstance().getReference("builds").child(user.getUid());
        setUpFirebaseAdapter();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CarListActivity.this,BuildCarAcitivty.class));
            }
        });
    }

    private void setUpFirebaseAdapter() {
        FirebaseRecyclerAdapter firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Car, FirebaseCarViewHolder>(Car.class, R.layout.rv_car_firebase, FirebaseCarViewHolder.class,
                databaseReference) {
            @Override
            protected void populateViewHolder(FirebaseCarViewHolder viewHolder, Car model, int position) {
                viewHolder.bindCar(model);
            }


        };
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(CarListActivity.this);
        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(firebaseRecyclerAdapter);
      //  progressDialog.dismiss();


    }

}
