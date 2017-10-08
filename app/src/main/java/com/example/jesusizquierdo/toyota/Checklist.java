package com.example.jesusizquierdo.toyota;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Checklist extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checklist);
        Toast.makeText(Checklist.this, "THIS IS A DEMO OF THE CHECKLIST",Toast.LENGTH_SHORT).show();

    }
}
