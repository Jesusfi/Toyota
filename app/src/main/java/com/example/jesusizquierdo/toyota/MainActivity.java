package com.example.jesusizquierdo.toyota;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.jesusizquierdo.toyota.classes.SimpleProfile;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
    TextView greeting;
    CardView dealership, localNFC, buildCar, chat, viewBuilds;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth = FirebaseAuth.getInstance();
        final FirebaseUser user = firebaseAuth.getCurrentUser();


        dealership = (CardView) findViewById(R.id.cv_find_dealer);
        localNFC = (CardView) findViewById(R.id.cv_get_local_build);
        buildCar = (CardView) findViewById(R.id.cv_build_car);
        chat = (CardView) findViewById(R.id.cv_ai_chat);
        viewBuilds = (CardView) findViewById(R.id.cv_view_builds);



        dealership.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MapsActivity.class));

            }
        });
        localNFC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Nfc.class);
                intent.putExtra("get", 0);
                startActivity(intent);
            }
        });
        buildCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, BuildCarAcitivty.class));
            }
        });
        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Chat.class));

            }
        });
        viewBuilds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,CarListActivity.class));
            }
        });






        greeting = (TextView) findViewById(R.id.tv_user_name);
//        Button maps = (Button) findViewById(R.id.find_dealer);
//        Button build = (Button) findViewById(R.id.btn_build_car);
//        Button viewBuilds = (Button) findViewById(R.id.btn_view_builds);
//        Button getNfc = (Button) findViewById(R.id.getnfc);
//        Button aiChat = (Button) findViewById(R.id.ai_chat);
//        aiChat.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//            }
//        });
//        getNfc.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                //startActivity(new Intent(MainActivity.this, Nfc.class));
//            }
//        });
//
//        viewBuilds.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
//        build.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(MainActivity.this, BuildCarAcitivty.class));
//            }
//        });
            displayUserName();
//
//        maps.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//            }
//        });
        Button signOut = (Button) findViewById(R.id.btn_sign_out);
        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseAuth.signOut();
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(MainActivity.this,LoginActivity.class));
                finish();
            }
        });
    }
    public void displayUserName(){
        FirebaseUser fUser = firebaseAuth.getCurrentUser();
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Profile").child(fUser.getUid());

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                SimpleProfile user = dataSnapshot.getValue(SimpleProfile.class);
                greeting.setText("Hello, " + user.getName()+" how are you?");
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
